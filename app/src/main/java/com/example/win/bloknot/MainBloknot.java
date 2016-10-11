package com.example.win.bloknot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import EditText;
import ListView;

public class MainBloknot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bloknot);

        ListView listView;
        EditText editText = null;

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editText);

        final ArrayList<String> catnames = new ArrayList<String>();

        final ArrayAdapter<String> adapter;// Создаём адаптер ArrayAdapter, чтобы привязать массив к ListView
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, catnames);

        listView.setAdapter(adapter);// // Привяжем массив через адаптер к ListView
        /*Это для разрисовки разными цветами чётного и нечётного
        listView.setBackgroundColor(Color.RED);

        if (position %2==0){
            throw.setBackgroundColor(Color.RED);
        }else {
            listView.setBackgroundColor(Color.RED);
        }
        return ;
*/
        // Прослушиваем нажатия клавиш
        final EditText finalEditText = editText;
        editText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // TODO Auto-generated method stub
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    if (keyCode == KeyEvent.KEYCODE_ENTER) {
                        catnames.add(0, finalEditText.getText().toString());
                        adapter.notifyDataSetChanged();//Сообщает прикрепленные наблюдателей, что основные данные были изменены, и любой вид отражает набор данных должен освежить себя.
                        finalEditText.setText("");
                        return true;
                    }
                return false;
            }
        });
        //ДУмал будет правильно
        final int position;

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                removeitem(position);
            }

            private void removeitem(int position) {
                catnames.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

    }
}
