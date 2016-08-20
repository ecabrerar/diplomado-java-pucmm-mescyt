/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.servicios.rest.cliente;

import java.io.IOException;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.HttpHeaders;

/**
 *
 * @author ecabrerar
 */
public class RequestFilterBasico implements ClientRequestFilter{

    @Override
    public void filter(ClientRequestContext crc) throws IOException {
        
        crc.getHeaders().add(HttpHeaders.CONTENT_TYPE, "application/json");
    }
    
}
