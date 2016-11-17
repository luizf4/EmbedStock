package embedstock.com.br.embedstock;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import embedstock.com.br.embedstock.model.Estoque;

public class ConsultaEstoqueActivity extends AppCompatActivity {

    private List<Estoque> estoque = new ArrayList();
    private LocalQtdArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta_estoque);

        estoque.add(new Estoque(1L,1L,"P01",50));
        estoque.add(new Estoque(2L,2L,"P02",3));
        estoque.add(new Estoque(3L,3L,"P03",5));

        adapter = new LocalQtdArrayAdapter(this, 0, estoque);
        ((ListView)findViewById(R.id.lista_qtd_locais)).setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_consulta_estoque, menu);

        //Pega o Componente.
        SearchView mSearchView = (SearchView) menu.findItem(R.id.consultar_estoque)
                .getActionView();
        //Define um texto de ajuda:
        mSearchView.setQueryHint("Consultar Estoque");

        // exemplos de utilização:
        //mSearchView.setOnQueryTextListener(this);
        return true;
    }

}
