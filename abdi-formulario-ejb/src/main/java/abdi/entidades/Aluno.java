package abdi.entidades;

import abdi.formulario.entidades.AplicacaoEntidade;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "abdi.formulario.entidades.Aluno")
@Table(schema = "estudo", name = "ALUNO")
@NamedQueries(
        {@NamedQuery(name = "LISTAR", query = "select aluno from abdi.formulario.entidades.Aluno aluno")}
)
public class Aluno extends AplicacaoEntidade {
    private static final long serialVersionUID = 2587714088123111055L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer codigo;

    @Column(name = "NOME")
    private String nome;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}