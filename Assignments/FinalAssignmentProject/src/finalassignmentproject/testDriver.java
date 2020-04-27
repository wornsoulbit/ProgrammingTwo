/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalassignmentproject;

import java.io.FileNotFoundException;

/**
 *
 * @author Alex
 */
public class testDriver {

    public static void main(String[] args) throws UnknownPetTypeException, FileNotFoundException {
        new PettingZooApp().run();
    }
}
