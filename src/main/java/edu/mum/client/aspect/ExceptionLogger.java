package edu.mum.client.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;

/**
 * Created by Rabin Shrestha on 8/15/2017.
 */

@Component
@Aspect
public class ExceptionLogger {

    @AfterThrowing(pointcut = "within(edu.mum.client..*)", throwing = "ex")
    public void controllerExceptionLogger(JoinPoint method, Throwable ex) {
        System.out.println("<<<<======== Exception Occured : " + LocalDate.now() + " =============>>>>");
        System.out.println("Class name :" + method.getTarget().toString());
        System.out.println("Method Name :" + method.getSignature().getName());
        System.out.println(" Exception details :" + ex);
        try {
            File file=new File("errorLog.txt");
            file.createNewFile();
            FileWriter fw = new FileWriter(file,true);
            fw.write("<<<<======== Exception occured : " + LocalDate.now() + " =============>>>>\n");
            fw.write("Class name :" + method.getTarget().toString()+"\n");
            fw.write("Method Name :" + method.getSignature().getName()+"\n");
            fw.write("Exception Details :" + ex.getLocalizedMessage()+"\n"+ex.getCause()+"\n"+ex.getStackTrace()+"\n"+ex.getMessage());
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }



}
