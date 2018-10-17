/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryDarkSkin;

import FactoryDefault.DefaultBack;
import FactoryDefault.DefaultBlock;
import blok.interfaces.IBack;
import blok.interfaces.IBlock;
import blok.interfaces.ISkinFactory;

/**
 *
 * @author aluno
 */
public class DarkSkin implements ISkinFactory {
    
    public IBack createBack() {
            	
		return new DarkBack();
	}


	public IBlock createBlock() {
		
		return new DarkBlock();
	}

    
}
