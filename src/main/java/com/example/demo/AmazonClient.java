package com.example.demo;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.codepipeline.model.ActionContext;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
//import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

@Service
public class AmazonClient extends HttpServlet{
    //HttpServletRequest request=null;

    private AmazonS3 s3client;
    public static String yes="";  /*  @Value("${amazonProperties.endpointUrl}")
    private String endpointUrl;
    @Value("${amazonProperties.bucketName}")
    private String bucketName;
    @Value("${amazonProperties.accessKey}")
    private String accessKey;
    @Value("${amazonProperties.secretKey}")
    private String secretKey;*/

    @SuppressWarnings("deprecation")
	@PostConstruct
    private void initializeAmazon() {
        AWSCredentials credentials = new BasicAWSCredentials("AKIAIV7NTOPDCTMA4L2A", "rXJka11SdWxaLRhmLlRGwF6JnFrBJGxRlQvb127H");
        this.s3client = new AmazonS3Client(credentials);
    }

    
	public String uploadFile(MultipartFile multipartFile) {
        String fileUrl = "";
        
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = generateFileName(multipartFile);
          
            fileUrl = "http://sgolifiles.images.s3.amazonaws.com/"+ fileName;
            uploadFileTos3bucket(fileName, file,fileUrl);
            file.delete();
            
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        
        
       return fileUrl; 
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }

    private void uploadFileTos3bucket(String fileName, File file,String fileUrl) {

        s3client.putObject(new PutObjectRequest("sgolifiles.images", fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
        //request.getSession().setAttribute("key",fileUrl);
    }
    public String send(String pass) {
    	return pass;
    }
    
}
