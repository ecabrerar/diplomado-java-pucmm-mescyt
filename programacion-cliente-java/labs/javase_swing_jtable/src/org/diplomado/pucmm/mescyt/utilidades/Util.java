package org.diplomado.pucmm.mescyt.utilidades;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

/**
 *  
 * @author ecabrerar
 * @date Aug 4, 2016
 */
public class Util {

    private Util() {
    }

    /**
     *  Convertir una cadena de caracteres a MD5. Por ejemplo: una contraseña.
     *  String md5 =Util.toMD5(mensaje);
     * 
     * @param mensaje
     * @return
     * @throws NoSuchAlgorithmException 
     */
    
    public static String toMD5(String mensaje) throws NoSuchAlgorithmException {

        MessageDigest md5 = MessageDigest.getInstance("MD5");

        return (new HexBinaryAdapter()).marshal(md5.digest(mensaje.getBytes()));

    }
}
