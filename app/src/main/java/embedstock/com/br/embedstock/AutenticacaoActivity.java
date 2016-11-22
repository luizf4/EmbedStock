package embedstock.com.br.embedstock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import embedstock.com.br.embedstock.DB.BDEmbedStock;
import embedstock.com.br.embedstock.model.Usuario;


public class AutenticacaoActivity extends Activity {

    //Usuario autenticacao = new Usuario();
    private BDEmbedStock dbUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autenticacao);
        dbUsuario = new BDEmbedStock(this);


    }

    public void autenticar(View view) {

        EditText usuario = (EditText) findViewById(R.id.text_usuario);
        EditText senha = (EditText) findViewById(R.id.text_senha);
        Usuario user = new Usuario();

        user.setUsuario(usuario.getText().toString());
        user.setSenha(usuario.getText().toString());
        user.setNivel_Acesso("1");
        dbUsuario.salvarUsuario(user);

        if(dbUsuario.autenticarUsuario(usuario.getText().toString(),
                senha.getText().toString()) == true){

            Toast.makeText(this, "Usuário " + usuario.getText() +
                    " Autenticado", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
            //limpaCaixas();
            finish();

        }else{

            Toast.makeText(this, "Usuário ou Senha incorreto", Toast.LENGTH_SHORT).show();
            limpaCaixas();

        }
    }

    /**
     * Método para limpar as EditTexts e focar a caixa "usuário"
     */
    public void limpaCaixas(){

        ((EditText) findViewById(R.id.text_usuario)).setText("");
        ((EditText) findViewById(R.id.text_senha)).setText("");
        findViewById(R.id.text_usuario).requestFocus();

    }
}
