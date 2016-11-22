package embedstock.com.br.embedstock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import embedstock.com.br.embedstock.model.Estoque;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.trocar_senha) {

            startActivity(new Intent(this, TrocaSenhaActivity.class));
            return true;
        }else if(id == R.id.consultar_estoque){

            startActivity(new Intent(this, EstoqueActivity.class));
            return true;
        }else if (id == R.id.entrada_produto){

            startActivity(new Intent (this, ProdutoActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void telaProduto(View view){

            startActivity(new Intent(this, ProdutoActivity.class));

    }

    public void telaEstoque(View view){

        startActivity(new Intent(this, EstoqueActivity.class));

    }

    public void cadastroUsuario(View view){

        startActivity(new Intent(this, TrocaSenhaActivity.class));

    }

}
