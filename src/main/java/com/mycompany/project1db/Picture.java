/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1db;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author samia
 */
public class Picture {
    private int ID_Picture;
    private BufferedImage image;

    public Picture(int ID_Picture, BufferedImage image) {
        this.ID_Picture = ID_Picture;
        this.image = image;
    }

    public int getID_Picture() {
        return ID_Picture;
    }

    public void setID_Picture(int ID_Picture) {
        this.ID_Picture = ID_Picture;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
}
