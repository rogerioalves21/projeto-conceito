package br.com.sicoob.sisbr.ejb;

import javax.ejb.Remote;

@Remote
public interface IRestClientServico {

  String consumir(ReqRestDTO requisicao);
  
}
