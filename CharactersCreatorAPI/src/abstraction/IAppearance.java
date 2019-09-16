/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstraction;

/**
 *
 * @author Fabricio Ceciliano
 */
public interface IAppearance extends IPrototype<IAppearance>{
    public String getLook(Enum code);
}
