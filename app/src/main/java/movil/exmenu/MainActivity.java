package movil.exmenu;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int HIDE = 0;
    private static final int MENU1 = 1;
    private static final int MENU2 = 2;

    Button btnHide, btnShow1, btnShow2;
    int state;

    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnHide = (Button) findViewById(R.id.btn_hide);
        btnShow1 = (Button) findViewById(R.id.btn_show_1);
        btnShow2 = (Button) findViewById(R.id.btn_show_2);

        btnHide.setOnClickListener(this);
        btnShow1.setOnClickListener(this);
        btnShow2.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        if(state == HIDE){
            menu.clear();
        }else if(state == MENU1){
            inflater.inflate(R.menu.menu_main_1, menu);
        }else{
            inflater.inflate(R.menu.menu_main_2, menu);
        }

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_hide:
                hideMenu();
                break;
            case R.id.btn_show_1:
                showMenu1();
                break;
            case R.id.btn_show_2:
                showMenu2();
                break;
        }
    }

    private void hideMenu() {
        state = HIDE;
        onPrepareOptionsMenu(menu);
    }
    private void showMenu1() {
        state = MENU1;
        onPrepareOptionsMenu(menu);
    }
    private void showMenu2() {
        state = MENU2;
        onPrepareOptionsMenu(menu);
    }


}
