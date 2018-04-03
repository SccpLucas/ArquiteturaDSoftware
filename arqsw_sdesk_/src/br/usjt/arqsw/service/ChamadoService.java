package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 *  @author Lucas Ribeiro Rios 816114323 (SIN3AN-MCA1)
 */

@Service
public class ChamadoService {
	ChamadoDAO dao;
	
	@Autowired
	public ChamadoService(ChamadoDAO dao){
		this.dao = dao;
	}
	
	public int novoChamado(Chamado chamado) throws IOException{
		chamado.setDt_abertura(new Date());
		chamado.setDt_fechamento(null);
		chamado.setStatus(Chamado.ABERTO);
		return -1;
		//return dao.inserirChamado(chamado);
	}

	public List<Chamado> listarChamados(Fila fila) throws IOException{
		return dao.listarChamados(fila);
	}

	public List <Chamado> listarChamados()throws IOException{
		return dao.listarChamados();
	}
	public void fecharChamados(ArrayList<Integer> lista) throws IOException{
		dao.fecharChamados(lista);
	}
}
