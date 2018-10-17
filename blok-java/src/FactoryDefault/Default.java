package FactoryDefault;

import javax.swing.ImageIcon;

import blok.interfaces.IBack;
import blok.interfaces.IBlock;
import blok.interfaces.ISkinFactory;

public class Default implements ISkinFactory {

	@Override
	public IBack createBack() {
            	
		return new DefaultBack();
	}

	@Override
	public IBlock createBlock() {
		
		return new DefaultBlock();
	}

}
