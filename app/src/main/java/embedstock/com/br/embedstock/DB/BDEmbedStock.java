package embedstock.com.br.embedstock.DB;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import embedstock.com.br.embedstock.model.Usuario;

public class BDEmbedStock extends SQLiteOpenHelper {



    public BDEmbedStock(Context context){

        super(context, "Usuario", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Funcionario (id_registro_emp integer PRIMARY KEY AUTOINCREMENT," +
                " cpf VARCHAR(11) NOT NULL, nome VARCHAR(200) NOT NULL);");


        db.execSQL("CREATE TABLE Usuario (id_registro_emp integer PRIMARY KEY AUTOINCREMENT," +
                " usuario text NOT NULL UNIQUE, senha text not null," +
                " nivel_acesso text NOT NULL);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {



    }

    public Usuario salvarUsuario(Usuario usuario){

        SQLiteDatabase db = getWritableDatabase();

        try{

            ContentValues values = new ContentValues();
            values.put("usuario", usuario.getUsuario());
            values.put("senha", usuario.getSenha());
            values.put("nivel_acesso", usuario.getNivel_Acesso());

            if(usuario.getId_Registro_Emp() == null){

                long id = db.insert("Usuario", null, values);
                usuario.setId_Registro_Emp(id);

            }else{

                values.put("usuario", usuario.getUsuario());
                values.put("senha", usuario.getSenha());
                values.put("nivel_acesso", usuario.getNivel_Acesso());
                String[] where = new String[]{String.valueOf(usuario.getId_Registro_Emp())};
                db.update("Usuario", values, "id_registro_emp = ?", where);

            }

        }catch (Exception ex){

            ex.printStackTrace();
        }
        finally {

            db.close();

        }

        return usuario;

    }

    public boolean autenticarUsuario(String usuario, String senha){

        SQLiteDatabase db = getReadableDatabase();
        String[] where = new String[]{String.valueOf(usuario.toString())};
        boolean retorno = false;

        try {
            Cursor cursor = db.rawQuery("SELECT * FROM Usuario WHERE usuario = ? ", where);

            cursor.moveToFirst();

            String u = cursor.getString(1);
            String s = cursor.getString(2);


            if (u.toString().equals(usuario.toString()) && s.toString().equals(senha.toString())) {


                    retorno = true;


                } else {

                    retorno = false;
                }


            cursor.close();

        }catch (Exception ex){

            ex.printStackTrace();

        }finally {

            db.close();
        }

        return retorno;
    }

}
