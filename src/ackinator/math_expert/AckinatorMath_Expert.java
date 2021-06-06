/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ackinator.math_expert;


import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.Border;


/**
 *
 * @author Dell
 */
class BackgroundImage extends JPanel {
    Image image;
    static int imgv = 0;
    public BackgroundImage() {
        try {
            if (imgv == 0)
                image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("ackinator.jpg"), "ackinator.jpg"));
            else {
                image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("Math.jpg"), "Math.jpg"));
            }
            imgv++;
        } catch (IOException e) { /*handled in paintComponent()*/ }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null)
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
public class AckinatorMath_Expert {
    JTextField question;
      JFrame screen;
      JPanel innerScreen2;
      JFrame solutionFrame;
      JPanel solutionPannel;
    public AckinatorMath_Expert() {
        question=new JTextField();
        screen=new JFrame("Math_solver");
      innerScreen2=new BackgroundImage();
      solutionFrame=new JFrame("Math_solver_answer");
      
        innerScreen2.setLayout(null);
       JButton challenge=new JButton();
       challenge.setSize(430,96);
       challenge.setLocation(595,400);
       
       challenge.setBackground(new Color(255,0,0,20));
      challenge.setOpaque(false);

    
   question.setForeground(Color.white);

        question.setBackground(Color.BLACK);
         
            question.setSize(450,50);
            question.setLocation(598,270);
             
 
 challenge.setContentAreaFilled(false);
       

        challenge.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldActionPerformed(evt);
            }

            private void jTextFieldActionPerformed(ActionEvent evt) {
                int[] nos={0,0,0,0,0};    
                int k=-1;
             int mul=1;
             int val=0;
             int m=-1;
              int[] md={0,0,0,0,0};  
                  int zero=0;  
             int[] nos2={0,0,0,0,0,0,0};
         int dont=0;
            
                        for(int i=0;i<=question.getText().length()-1; i++){
                
                       if(question.getText().contains("add")&& question.getText().contains("subtract")){
                           dont=-1;
                           String[] addPorttion=new String[question.getText().length()];
                           String[] subPortion=new String[question.getText().length()];
                           int indexForadd=0;
                           int indexForsub=0;
                           //Checkinh question asking add first then subtract or asking subtract first then add
                           for(int j=0;j<=question.getText().length()-1;j++){
                           if(j+1<=question.getText().length()-1 &&j+2<=question.getText().length() ){
                               if(question.getText().charAt(j)=='a' && question.getText().charAt(j+1)=='d'&& question.getText().charAt(j+2)=='d'){
                                      indexForadd=j;
                                      
                               }
                               
                               
                              if(question.getText().charAt(j)=='s' && question.getText().charAt(j+1)=='u'&& question.getText().charAt(j+2)=='b'){
                                      indexForsub=j;
                                      
                               }
                           }
                           }
                           if(indexForadd>indexForsub){
                               
                             for(int n=0;n<indexForadd; n++){
                                
                                 
                            if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                k++;
                               
                                while (n<indexForadd-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                    if(k<nos.length){
                                        nos[k]=(nos[k]*10) +(question.getText().charAt(n)-48);
                                    }        
                                        n++;
                                                
                                }
                            }
                                          
                           }
                             ///////////////////////////////////////////////////
                           
                             for(int n=indexForadd;n<question.getText().length();n++){
                                 
                              if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                m++;
                               
                                while (n<=question.getText().length()-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                       if(m<nos2.length){
                                        nos2[m]=(nos2[m]*10) +(question.getText().charAt(n)-48);
                                       }
                                                n++;
                                }
                            } 
                             
                             
                             }
                             int sub=0;
                           for(int j=0;j<nos.length;j++){
                              sub=nos[j]-sub;
                           }
                           /////////////////////////
                           int[] temp=new int[nos2.length+1];
                           temp[0]=sub;
                           for(int j=0;j<nos2.length;j++){
                            temp[j+1]=nos2[j];
                           }
                           
                               summ(temp);
                           }
                           else{
                                  for(int n=0;n<indexForsub; n++){
                                
                                 
                            if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                k++;
                               
                                while (n<indexForsub-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                    if(k<nos.length){
                                        nos[k]=(nos[k]*10) +(question.getText().charAt(n)-48);
                                    }        
                                        n++;
                                                
                                }
                            }
                                          
                           }
                             ///////////////////////////////////////////////////
                           
                             for(int n=indexForsub;n<question.getText().length();n++){
                                 
                              if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                m++;
                               
                                while (n<=question.getText().length()-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                       if(m<nos2.length){
                                        nos2[m]=(nos2[m]*10) +(question.getText().charAt(n)-48);
                                       }
                                                n++;
                                }
                            } 
                             
                             
                             }
                             int add=0;
                           for(int j=0;j<nos.length;j++){
                              add=nos[j]+add;
                           }
                           /////////////////////////
                           int[] temp=new int[nos2.length+1];
                        
                           for(int j=0;j<nos2.length;j++){
                            temp[j]=nos2[j];
                            
                           }
                           temp[nos2.length]=add;
                           
                               sub(temp);
                           }
                           
                                         
                     
                       }
                       else if(question.getText().contains("multiply")&& question.getText().contains("add")){
                           dont=-1;
                         
                           int indexForadd=0;
                           int indexFormul=0;
                           //Checkinh question asking add first then subtract or asking subtract first then add
                           for(int j=0;j<=question.getText().length()-1;j++){
                           if(j+1<=question.getText().length()-1 &&j+2<=question.getText().length() ){
                               if(question.getText().charAt(j)=='a' && question.getText().charAt(j+1)=='d'&& question.getText().charAt(j+2)=='d'){
                                      indexForadd=j;
                                      
                               }
                               
                               
                              if(question.getText().charAt(j)=='m' && question.getText().charAt(j+1)=='u'&& question.getText().charAt(j+2)=='l'){
                                      indexFormul=j;
                                      
                               }
                           }
                           }
                           if(indexForadd>indexFormul){
                               
                             for(int n=0;n<indexForadd; n++){
                                
                                 
                            if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                k++;
                             
                                while (n<indexForadd-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                    if(k<md.length){
                                        if((question.getText().charAt(n)-48)==0){
                                            zero=-1;
                                           }
                                        md[k]=(md[k]*10) +(question.getText().charAt(n)-48);
                                    }        
                                        n++;
                                                
                                }
                            }
                                          
                           }
                             ///////////////////////////////////////////////////
                         
                             for(int n=indexForadd;n<question.getText().length();n++){
                                 
                              if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                m++;
                               
                                while (n<=question.getText().length()-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                       if(m<nos2.length){
                                          
                                        nos2[m]=(nos2[m]*10) +(question.getText().charAt(n)-48);
                                       }
                                                n++;
                                }
                            } 
                             
                             
                             }
                             int mult=1;
                          
                            if(zero==-1){
                            
                            mult=0;
                           }
                            else{
                           for(int j=0;j<nos.length;j++){
                            if(md[j]!=0){
                               mult=md[j]*mult;
                            }
                           }
                             
                           }
                           /////////////////////////
                           int[] temp=new int[nos2.length+1];
                           temp[0]=mult;
                           for(int j=0;j<nos2.length;j++){
                            temp[j+1]=nos2[j];
                           }
                           
                               summ(temp);
                           }
                           else{
                                  for(int n=0;n<indexFormul; n++){
                                
                                 
                            if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                k++;
                               
                                while (n<indexFormul-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                    if(k<nos.length){
                                        nos[k]=(nos[k]*10) +(question.getText().charAt(n)-48);
                                    }        
                                        n++;
                                                
                                }
                            }
                                          
                           }
                             ///////////////////////////////////////////////////
                           
                             for(int n=indexFormul;n<question.getText().length();n++){
                                 
                              if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                m++;
                               
                                while (n<=question.getText().length()-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                       if(m<md.length){
                                      
                                       if((question.getText().charAt(n)-48)==0){
                                            zero=-1;
                                           }                                      
                                            md[m]=(md[m]*10) +(question.getText().charAt(n)-48);
                                       
                                       }
                                                n++;
                                }
                            } 
                             
                             
                             }
                            
                             int add=0;
                           for(int j=0;j<nos.length;j++){
                              add=nos[j]+add;
                           }
                          
                           /////////////////////////
                           int[] temp=new int[md.length+1];
                        if(zero==-1){
                         for(int j=0;j<md.length;j++){
                              temp[j]=0;
                             
                         }
                        }
                         else{
                           for(int j=0;j<md.length;j++){
                              if(md[j]!=0){     
                               temp[j]=md[j];
                              
                              }
                              else{
                              temp[j]=1;
                              }
                             
                              
                           }
                           temp[md.length]=add;
                                 }
                          
                               mul(temp);
                           }
                           
                                         
                     
                       }
                          else if(question.getText().contains("multiply")&& question.getText().contains("subtract")){
                           dont=-1;
                         
                           int indexForsub=0;
                           int indexFormul=0;
                           //Checkinh question asking add first then subtract or asking subtract first then add
                           for(int j=0;j<=question.getText().length()-1;j++){
                           if(j+1<=question.getText().length()-1 &&j+2<=question.getText().length() ){
                               if(question.getText().charAt(j)=='s' && question.getText().charAt(j+1)=='u'&& question.getText().charAt(j+2)=='b'){
                                      indexForsub=j;
                                      
                               }
                               
                               
                              if(question.getText().charAt(j)=='m' && question.getText().charAt(j+1)=='u'&& question.getText().charAt(j+2)=='l'){
                                      indexFormul=j;
                                      
                               }
                           }
                           }
                           if(indexForsub>indexFormul){
                               
                             for(int n=0;n<indexForsub; n++){
                                
                                 
                            if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                k++;
                             
                                while (n<indexForsub-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                    if(k<md.length){
                                        if((question.getText().charAt(n)-48)==0){
                                            zero=-1;
                                           }
                                        md[k]=(md[k]*10) +(question.getText().charAt(n)-48);
                                    }        
                                        n++;
                                                
                                }
                            }
                                          
                           }
                             ///////////////////////////////////////////////////
                         
                             for(int n=indexForsub;n<question.getText().length();n++){
                                 
                              if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                m++;
                               
                                while (n<=question.getText().length()-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                       if(m<nos2.length){
                                          
                                        nos2[m]=(nos2[m]*10) +(question.getText().charAt(n)-48);
                                       }
                                                n++;
                                }
                            } 
                             
                             
                             }
                             int mult=1;
                          
                            if(zero==-1){
                            
                            mult=0;
                           }
                            else{
                           for(int j=0;j<nos.length;j++){
                            if(md[j]!=0){
                               mult=md[j]*mult;
                            }
                           }
                             
                           }
                           /////////////////////////
                           int[] temp=new int[nos2.length+1];
                       
                           for(int j=0;j<nos2.length;j++){
                            temp[j]=nos2[j];
                           }
                               temp[nos2.length]=mult;
                           
                               sub(temp);
                           }
                           else{
                                  for(int n=0;n<indexFormul; n++){
                                
                                 
                            if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                k++;
                               
                                while (n<indexFormul-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                    if(k<nos.length){
                                        nos[k]=(nos[k]*10) +(question.getText().charAt(n)-48);
                                    }        
                                        n++;
                                                
                                }
                            }
                                          
                           }
                             ///////////////////////////////////////////////////
                           
                             for(int n=indexFormul;n<question.getText().length();n++){
                                 
                              if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                m++;
                               
                                while (n<=question.getText().length()-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                       if(m<md.length){
                                      
                                       if((question.getText().charAt(n)-48)==0){
                                            zero=-1;
                                           }                                      
                                            md[m]=(md[m]*10) +(question.getText().charAt(n)-48);
                                       
                                       }
                                                n++;
                                }
                            } 
                             
                             
                             }
                            
                             int sub=0;
                           for(int j=0;j<nos.length;j++){
                              sub=nos[j]-sub;
                           }
                          
                           /////////////////////////
                           int[] temp=new int[md.length+1];
                        if(zero==-1){
                         for(int j=0;j<md.length;j++){
                              temp[j]=0;
                             
                         }
                        }
                         else{
                           for(int j=0;j<md.length;j++){
                              if(md[j]!=0){     
                               temp[j]=md[j];
                              
                              }
                              else{
                              temp[j]=1;
                              }
                             
                              
                           }
                           temp[md.length]=sub;
                                 }
                          
                               mul(temp);
                           }
                           
                                         
                     
                       }
                       
                        else if(question.getText().contains("divide")&& question.getText().contains("multiply")){
                           dont=-1;
                         
                           int indexFormul=0;
                           int indexFordiv=0;
                           //Checkinh question asking add first then subtract or asking subtract first then add
                           for(int j=0;j<=question.getText().length()-1;j++){
                           if(j+1<=question.getText().length()-1 &&j+2<=question.getText().length() ){
                               if(question.getText().charAt(j)=='m' && question.getText().charAt(j+1)=='u'&& question.getText().charAt(j+2)=='l'){
                                      indexFormul=j;
                                      
                               }
                               
                               
                              if(question.getText().charAt(j)=='d' && question.getText().charAt(j+1)=='i'&& question.getText().charAt(j+2)=='v'){
                                      indexFordiv=j;
                                      
                               }
                           }
                           }
                           if(indexFormul>indexFordiv){
                               
                             for(int n=0;n<indexFormul; n++){
                                
                                 
                            if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                k++;
                             
                                while (n<indexFormul-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                    if(k<md.length){
                                        if((question.getText().charAt(n)-48)==0){
                                            zero=-1;
                                           }
                                        md[k]=(md[k]*10) +(question.getText().charAt(n)-48);
                                    }        
                                        n++;
                                                
                                }
                            }
                                          
                           }
                             ///////////////////////////////////////////////////
                         
                             for(int n=indexFormul;n<question.getText().length();n++){
                             
                              if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                m++;
                               
                                while (n<=question.getText().length()-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                       if(m<nos2.length){
                                        
                                       
                                          
                                        nos2[m]=(nos2[m]*10) +(question.getText().charAt(n)-48);
                                       }
                                                n++;
                                }
                            } 
                             
                             
                             }
                             float div=1;
                          
                            if(zero==-1){
                            
                              div=0;
                              int t[]=new int[1];
                              t[0]=0;
                                divide(t);
                           }
                            else{
                                
                           for(int j=0;j<md.length;j++){
                               
                               if(j+1<md.length){
                               if(md[j]!=0 && md[j+1]!=0 ){
                                    
                                    div=(md[j]/md[j+1]);
                            }
                           }
                           }
                             
                           }
                              
                           /////////////////////////
                           int[] temp=new int[nos2.length+1];
                           temp[0]=(int)div;
                           for(int j=0;j<nos2.length;j++){
                            if(nos2[j]!=0){
                               temp[j+1]=nos2[j];
                            }
                            else{
                            temp[j+1]=1;
                            }
                           }
                           
                           
                               mul(temp);
                           }
                           else{
                                  for(int n=0;n<indexFordiv; n++){
                                
                                 
                            if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                k++;
                               
                                while (n<indexFordiv-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                    if(k<nos.length){
                                        nos[k]=(nos[k]*10) +(question.getText().charAt(n)-48);
                                    }        
                                        n++;
                                                
                                }
                            }
                                          
                           }
                             ///////////////////////////////////////////////////
                           
                             for(int n=indexFordiv;n<question.getText().length();n++){
                                 
                              if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                m++;
                               
                                while (n<=question.getText().length()-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                       if(m<md.length){
                                      
                                       if((question.getText().charAt(n)-48)==0){
                                            zero=-1;
                                           }                                      
                                            md[m]=(md[m]*10) +(question.getText().charAt(n)-48);
                                       
                                       }
                                                n++;
                                }
                            } 
                             
                             
                             }
                            
                             int mult=1;
                           for(int j=0;j<nos.length;j++){
                               if(nos[j]!=0)
                              mult=nos[j]*mult;
                           }
                          
                           /////////////////////////
                           int[] temp=new int[md.length+1];
                        if(zero==-1){
                         for(int j=0;j<md.length;j++){
                              temp[j]=0;
                             
                         }
                        }
                         else{
                           for(int j=0;j<md.length;j++){
                              if(md[j]!=0){     
                               temp[j]=md[j];
                              
                              }
                              else{
                              temp[j]=1;
                              }
                             
                              
                           }
                           temp[md.length]=mult;
                                 }
                          
                               divide(temp);
                           }
                           
                                         
                     
                       }
                          else if(question.getText().contains("divide")&& question.getText().contains("add")){
                           dont=-1;
                         
                           int indexForadd=0;
                           int indexFordiv=0;
                           //Checkinh question asking add first then subtract or asking subtract first then add
                           for(int j=0;j<=question.getText().length()-1;j++){
                           if(j+1<=question.getText().length()-1 &&j+2<=question.getText().length() ){
                               if(question.getText().charAt(j)=='a' && question.getText().charAt(j+1)=='d'&& question.getText().charAt(j+2)=='d'){
                                      indexForadd=j;
                                      
                               }
                               
                               
                              if(question.getText().charAt(j)=='d' && question.getText().charAt(j+1)=='i'&& question.getText().charAt(j+2)=='v'){
                                      indexFordiv=j;
                                      
                               }
                           }
                           }
                           if(indexForadd>indexFordiv){
                               
                             for(int n=0;n<indexForadd; n++){
                                
                                 
                            if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                k++;
                             
                                while (n<indexForadd-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                    if(k<md.length){
                                        if((question.getText().charAt(n)-48)==0){
                                            zero=-1;
                                           }
                                        md[k]=(md[k]*10) +(question.getText().charAt(n)-48);
                                    }        
                                        n++;
                                                
                                }
                            }
                                          
                           }
                             ///////////////////////////////////////////////////
                         
                             for(int n=indexForadd;n<question.getText().length();n++){
                                 
                              if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                m++;
                               
                                while (n<=question.getText().length()-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                       if(m<nos2.length){
                                          
                                        nos2[m]=(nos2[m]*10) +(question.getText().charAt(n)-48);
                                       }
                                                n++;
                                }
                            } 
                             
                             
                             }
                             float div=1;
                          
                            if(zero==-1){
                            
                              div=0;
                              int t[]=new int[1];
                              t[0]=0;
                                divide(t);
                           }
                            else{
                                
                           for(int j=0;j<md.length;j++){
                               
                               if(j+1<md.length){
                               if(md[j]!=0 && md[j+1]!=0 ){
                                    
                                    div=(md[j]/md[j+1]);
                            }
                           }
                           }
                             
                           }
                              
                           /////////////////////////
                           int[] temp=new int[nos2.length+1];
                           temp[0]=(int)div;
                           for(int j=0;j<nos2.length;j++){
                            temp[j+1]=nos2[j];
                           }
                           
                               summ(temp);
                           }
                           else{
                                  for(int n=0;n<indexFordiv; n++){
                                
                                 
                            if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                k++;
                               
                                while (n<indexFordiv-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                    if(k<nos.length){
                                        nos[k]=(nos[k]*10) +(question.getText().charAt(n)-48);
                                    }        
                                        n++;
                                                
                                }
                            }
                                          
                           }
                             ///////////////////////////////////////////////////
                           
                             for(int n=indexFordiv;n<question.getText().length();n++){
                                 
                              if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                m++;
                               
                                while (n<=question.getText().length()-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                       if(m<md.length){
                                      
                                       if((question.getText().charAt(n)-48)==0){
                                            zero=-1;
                                           }                                      
                                            md[m]=(md[m]*10) +(question.getText().charAt(n)-48);
                                       
                                       }
                                                n++;
                                }
                            } 
                             
                             
                             }
                            
                             int add=0;
                           for(int j=0;j<nos.length;j++){
                              add=nos[j]+add;
                           }
                          
                           /////////////////////////
                           int[] temp=new int[md.length+1];
                        if(zero==-1){
                         for(int j=0;j<md.length;j++){
                              temp[j]=0;
                             
                         }
                        }
                         else{
                           for(int j=0;j<md.length;j++){
                              if(md[j]!=0){     
                               temp[j]=md[j];
                              
                              }
                              else{
                              temp[j]=1;
                              }
                             
                              
                           }
                           temp[md.length]=add;
                                 }
                          
                               divide(temp);
                           }
                           
                                         
                     
                       }
                       else if(question.getText().contains("divide")&& question.getText().contains("subtract")){
                           dont=-1;
                         
                           int indexForsub=0;
                           int indexFordiv=0;
                           //Checkinh question asking add first then subtract or asking subtract first then add
                           for(int j=0;j<=question.getText().length()-1;j++){
                           if(j+1<=question.getText().length()-1 &&j+2<=question.getText().length() ){
                               if(question.getText().charAt(j)=='s' && question.getText().charAt(j+1)=='u'&& question.getText().charAt(j+2)=='b'){
                                      indexForsub=j;
                                      
                               }
                               
                               
                              if(question.getText().charAt(j)=='d' && question.getText().charAt(j+1)=='i'&& question.getText().charAt(j+2)=='v'){
                                      indexFordiv=j;
                                      
                               }
                           }
                           }
                           if(indexForsub>indexFordiv){
                               
                             for(int n=0;n<indexForsub; n++){
                                
                                 
                            if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                k++;
                             
                                while (n<indexForsub-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                    if(k<md.length){
                                        if((question.getText().charAt(n)-48)==0){
                                            zero=-1;
                                           }
                                        md[k]=(md[k]*10) +(question.getText().charAt(n)-48);
                                    }        
                                        n++;
                                                
                                }
                            }
                                          
                           }
                             ///////////////////////////////////////////////////
                         
                             for(int n=indexForsub;n<question.getText().length();n++){
                                 
                              if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                m++;
                               
                                while (n<=question.getText().length()-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                       if(m<nos2.length){
                                          
                                        nos2[m]=(nos2[m]*10) +(question.getText().charAt(n)-48);
                                       }
                                                n++;
                                }
                            } 
                             
                             
                             }
                             float div=1;
                          
                            if(zero==-1){
                            
                              div=0;
                              int t[]=new int[1];
                              t[0]=0;
                                divide(t);
                           }
                            else{
                                
                           for(int j=0;j<md.length;j++){
                               
                               if(j+1<md.length){
                               if(md[j]!=0 && md[j+1]!=0 ){
                                    
                                    div=(md[j]/md[j+1]);
                            }
                           }
                           }
                             
                           }
                              
                           /////////////////////////
                           int[] temp=new int[nos2.length+1];
                           
                           for(int j=0;j<nos2.length;j++){
                            temp[j]=nos2[j];
                           }
                           temp[nos2.length]=(int)div;
                           
                               sub(temp);
                           }
                           else{
                                  for(int n=0;n<indexFordiv; n++){
                                
                                 
                            if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                k++;
                               
                                while (n<indexFordiv-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                    if(k<nos.length){
                                        nos[k]=(nos[k]*10) +(question.getText().charAt(n)-48);
                                    }        
                                        n++;
                                                
                                }
                            }
                                          
                           }
                             ///////////////////////////////////////////////////
                           
                             for(int n=indexFordiv;n<question.getText().length();n++){
                                 
                              if(Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57){
                               
                                m++;
                               
                                while (n<=question.getText().length()-1 &&Integer.valueOf(question.getText().charAt(n))>=48 && Integer.valueOf(question.getText().charAt(n))<=57) {
                                       if(m<md.length){
                                      
                                       if((question.getText().charAt(n)-48)==0){
                                            zero=-1;
                                           }                                      
                                            md[m]=(md[m]*10) +(question.getText().charAt(n)-48);
                                       
                                       }
                                                n++;
                                }
                            } 
                             
                             
                             }
                            
                             int sub=0;
                           for(int j=0;j<nos.length;j++){
                              sub=nos[j]-sub;
                           }
                          
                           /////////////////////////
                           int[] temp=new int[md.length+1];
                        if(zero==-1){
                         for(int j=0;j<md.length;j++){
                              temp[j]=0;
                             
                         }
                        }
                         else{
                           for(int j=0;j<md.length;j++){
                              if(md[j]!=0){     
                               temp[j]=md[j];
                              
                              }
                              else{
                              temp[j]=1;
                              }
                             
                              
                           }
                           temp[md.length]=sub;
                                 }
                          
                               divide(temp);
                           }
                           
                                         
                     
                       }
                        
                     if(dont!=-1){
                            if(Integer.valueOf(question.getText().charAt(i))>=48 && Integer.valueOf(question.getText().charAt(i))<=57){
                               
                                k++;
                               // 
                                while (i<=question.getText().length()-1 &&Integer.valueOf(question.getText().charAt(i))>=48 && Integer.valueOf(question.getText().charAt(i))<=57) {
                                   
                                        nos[k]=(nos[k]*10) +(question.getText().charAt(i)-48);
                                                i++;
                                }
                            }
                                
                     
                    
                             
                        }
                        }
                        if(dont!=-1){
                    if(question.getText().contains("add")){
                         summ(nos);   
                        
                                              
                     }
                    else if(question.getText().contains("subtract")){
                        sub(nos);
                    }
                    else if(question.getText().contains("multiply")){
                     if(k+1<nos.length){
                        for(int j=k+1;j<nos.length;j++){
                        nos[j]=1;
                     }
                     }
                     mul(nos);
                    
                    }
                    else if(question.getText().contains("divide")){
                    if(k+1<nos.length){
                        for(int j=k+1;j<nos.length;j++){
                       
                        nos[j]=1;
                     }
                    }
                        divide(nos);
                    
                    }
                    else if(question.getText().contains("mod")){
                        modulus(nos);
                    }
                    else{
                  
                   
                               
                           BufferedReader objReader = null;
                try {
                String strCurrentLine;

                    objReader = new BufferedReader(new FileReader("D:\\33.png"));
	String sCurrentLine;
        	String read_string="";
                       int j=0;
while ((sCurrentLine = objReader.readLine()) != null) {
		read_string=read_string+sCurrentLine+'\n';
		}
                    System.out.println(read_string);
                

                    } catch (IOException e) {

                                e.printStackTrace();

                                    }
                    
                    
              
                   }
               }
            
                        
            }
        });
       
       
       
       
   JLabel eq=new JLabel("                                                      Enter your question below");
    
   eq.setForeground(Color.white);

       eq.setBackground(Color.BLACK);
         
            eq.setSize(450,50);
           eq.setLocation(598,220);
   
   
       
              
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

      
       
 
      
        
        innerScreen2.add(eq);
  innerScreen2.add(question);
  innerScreen2.add(challenge);
        screen.add(innerScreen2);

        screen.setSize((int) width - 200, (int) height - 200);
        screen.setResizable(false);
       screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        screen.setLocationRelativeTo(null);
        screen.setVisible(true);
     
         
    }
public void sub(int nos[]){

          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          double width = screenSize.getWidth();
          double height = screenSize.getHeight();
        screen.setVisible(false);
       screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
      solutionPannel=new BackgroundImage();
      solutionPannel.setSize((int) width - 200, (int) height - 200);
      solutionPannel.setBackground(Color.BLUE);
        solutionFrame.setSize((int) width - 200, (int) height - 200);
        solutionFrame.setResizable(false);
        solutionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        solutionFrame.setLocationRelativeTo(null);
        solutionFrame.setVisible(true);
        
        solutionPannel.setLayout(null);
        JLabel sums=new JLabel("sub=");
        sums.setSize(100,50);
        sums.setLocation(475,150);
       
        sums.setForeground(Color.black);
        
        JLabel total=new JLabel();
         total.setSize(100,50);
        total.setLocation(510,150);
        total.setForeground(Color.black);
      int sub=0;
    for(int i=0;i<nos.length;i++){
            sub=nos[i]-sub;
    }
    total.setText(String.valueOf(sub));
    
    solutionPannel.add(total);
     solutionPannel.add(sums);
     solutionFrame.add(solutionPannel);
       solutionFrame.setVisible(true);
  }
public void divide(int nos[]){
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          double width = screenSize.getWidth();
          double height = screenSize.getHeight();
        screen.setVisible(false);
       screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
      solutionPannel=new BackgroundImage();
      solutionPannel.setSize((int) width - 200, (int) height - 200);
      solutionPannel.setBackground(Color.BLUE);
        solutionFrame.setSize((int) width - 200, (int) height - 200);
        solutionFrame.setResizable(false);
        solutionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        solutionFrame.setLocationRelativeTo(null);
        solutionFrame.setVisible(true);
        
        solutionPannel.setLayout(null);
        JLabel sums=new JLabel("divide=");
        sums.setSize(100,50);
        sums.setLocation(475,150);
       
        sums.setForeground(Color.black);
        
        JLabel total=new JLabel();
         total.setSize(100,50);
        total.setLocation(510,150);
        total.setForeground(Color.black);
      float divide=1;
      int bol=0;
    for(int i=0;i<nos.length;i++){
        if(nos[i]!=0)    
        divide=nos[i]/divide;
        else{
            bol=-1;
           
        }
    }
    if(bol==-1){
      total.setText(String.valueOf("infinity"));
    }
    else
    total.setText(String.valueOf(divide));
    
    solutionPannel.add(total);
     solutionPannel.add(sums);
     solutionFrame.add(solutionPannel);
       solutionFrame.setVisible(true);
  }
public void modulus(int nos[]){
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          double width = screenSize.getWidth();
          double height = screenSize.getHeight();
        screen.setVisible(false);
       screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
      solutionPannel=new BackgroundImage();
      solutionPannel.setSize((int) width - 200, (int) height - 200);
      solutionPannel.setBackground(Color.BLUE);
        solutionFrame.setSize((int) width - 200, (int) height - 200);
        solutionFrame.setResizable(false);
        solutionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        solutionFrame.setLocationRelativeTo(null);
        solutionFrame.setVisible(true);
        
        solutionPannel.setLayout(null);
        JLabel sums=new JLabel("mod=");
        sums.setSize(100,50);
        sums.setLocation(475,150);
       
        sums.setForeground(Color.black);
        
        JLabel total=new JLabel();
         total.setSize(100,50);
        total.setLocation(510,150);
        total.setForeground(Color.black);
      int mod=0;
      
      int k=0;
    for(int i=0;i<nos.length;i++){
        if(i+1<nos.length){
        if(nos[i+1]!=0 && nos[i]!=0)
            mod=(nos[i]%nos[i+1])+mod;
        }
    }
    total.setText(String.valueOf(mod));
    
    solutionPannel.add(total);
     solutionPannel.add(sums);
     solutionFrame.add(solutionPannel);
       solutionFrame.setVisible(true);
  }
public void mul(int nos[]){
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          double width = screenSize.getWidth();
          double height = screenSize.getHeight();
        screen.setVisible(false);
       screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
      solutionPannel=new BackgroundImage();
      solutionPannel.setSize((int) width - 200, (int) height - 200);
      solutionPannel.setBackground(Color.BLUE);
        solutionFrame.setSize((int) width - 200, (int) height - 200);
        solutionFrame.setResizable(false);
        solutionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        solutionFrame.setLocationRelativeTo(null);
        solutionFrame.setVisible(true);
        
        solutionPannel.setLayout(null);
        JLabel sums=new JLabel("mul=");
        sums.setSize(100,50);
        sums.setLocation(475,150);
       
        sums.setForeground(Color.black);
        
        JLabel total=new JLabel();
         total.setSize(100,50);
        total.setLocation(510,150);
        total.setForeground(Color.black);
      int mul=1;
    for(int i=0;i<nos.length;i++){
            
        mul=nos[i]*mul;
    }
    total.setText(String.valueOf(mul));
    
    solutionPannel.add(total);
     solutionPannel.add(sums);
     solutionFrame.add(solutionPannel);
       solutionFrame.setVisible(true);
  }
  public void summ(int nos[]){
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          double width = screenSize.getWidth();
          double height = screenSize.getHeight();
        screen.setVisible(false);
       screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
      solutionPannel=new BackgroundImage();
      solutionPannel.setSize((int) width - 200, (int) height - 200);
      solutionPannel.setBackground(Color.BLUE);
        solutionFrame.setSize((int) width - 200, (int) height - 200);
        solutionFrame.setResizable(false);
        solutionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        solutionFrame.setLocationRelativeTo(null);
        solutionFrame.setVisible(true);
        
        solutionPannel.setLayout(null);
        JLabel sums=new JLabel("sum=");
        sums.setSize(100,50);
        sums.setLocation(475,150);
       
        sums.setForeground(Color.black);
        
        JLabel total=new JLabel();
         total.setSize(100,50);
        total.setLocation(510,150);
        total.setForeground(Color.black);
      int sum=0;
    for(int i=0;i<nos.length;i++){
            sum+=nos[i];
    }
    total.setText(String.valueOf(sum));
    
    solutionPannel.add(total);
     solutionPannel.add(sums);
     solutionFrame.add(solutionPannel);
       solutionFrame.setVisible(true);
  }
    public static void main(String[] args) {
  
           AckinatorMath_Expert ackinatorMath_Expert=new AckinatorMath_Expert();
   
    }
    
}
