package embedstock.com.br.embedstock;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import embedstock.com.br.embedstock.model.Estoque;

public class LocalQtdArrayAdapter extends ArrayAdapter<Estoque>{

    private Context context;
    private List<Estoque> estoque;


    public LocalQtdArrayAdapter(Context context, int resource, List<Estoque> objects) {
        super(context, resource, objects);
        this.context = context;
        this.estoque = objects;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View linha = inflater.inflate(R.layout.qtd_locais, parent, false);
        TextView qtd = (TextView) linha.findViewById(R.id.text_quantidade);
        TextView local = (TextView) linha.findViewById(R.id.text_local);

        Estoque e = estoque.get(position);

        qtd.setText(Integer.valueOf(e.getQuantidade()).toString());
        local.setText(e.getLocal());
        return linha;
    }
}
