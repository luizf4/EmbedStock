package embedstock.com.br.embedstock.model;

public class Usuario {

    private Long id_Registro_Emp;
    private String usuario;
    private String senha;
    private String nivel_Acesso;

    public Long getId_Registro_Emp() {
        return id_Registro_Emp;
    }

    public void setId_Registro_Emp(Long id_Registro_Emp) {
        this.id_Registro_Emp = id_Registro_Emp;
    }

    public String getNivel_Acesso() {
        return nivel_Acesso;
    }

    public void setNivel_Acesso(String nivel_Acesso) {
        this.nivel_Acesso = nivel_Acesso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
