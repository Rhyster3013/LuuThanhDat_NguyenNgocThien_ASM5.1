package com.example.asm51;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asm51.adapter.NewsAdapter;
import com.example.asm51.adapter.OnItemClickListener;
import com.example.asm51.models.News;
import com.example.asm51.webpage.WebViewActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //insert product

        List<News> listNews = new ArrayList<>();
        listNews.add(new News( "Tin soc", "https://sinhvien.hutech.edu.vn/#/sinhvien/dashboard", "https://file1.hutech.edu.vn/file/news/9762551702614315.jpg"));


        NewsAdapter adapter = new NewsAdapter(listNews, (OnItemClickListener) this);
        RecyclerView rcvNews = findViewById(R.id.rcvNews);
        rcvNews.setAdapter(adapter);
        rcvNews.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvNews.addItemDecoration(itemDecoration);

        FloatingActionButton btnAdd = findViewById(R.id.fabAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Inflate the custom dialog layout
                View viewDialog = getLayoutInflater().inflate(R.layout.dialog_news, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setView(viewDialog);
                AlertDialog alert = builder.create();
                alert.show();

                //tiếp tục viết sự kiện trong viewDialog
                EditText txtTitle = viewDialog.findViewById(R.id.edtTitle);
                String vTitle = txtTitle.getText().toString();

                EditText txtImage = viewDialog.findViewById(R.id.edtImage);
                String vImage = txtImage.getText().toString();

                EditText txtLink = viewDialog.findViewById(R.id.edtLink);
                String vLink = txtLink.getText().toString();

                //sụ kien Save
                viewDialog.findViewById(R.id.btnDialogSaveProduct).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        News p = new News( vTitle, vLink, vImage);
                        listNews.add(p); //thêm vào
                        adapter.notifyItemInserted(listNews.size()-1);
                        //thong bao thành công
                        Toast.makeText(viewDialog.getContext(), "Thêm dữ liệu thành công", Toast.LENGTH_SHORT).show();
                        alert.dismiss(); //thoát khỏi dialog
                    }
                });
            }
        });

    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onItemClick(String url) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("URL", url);
        startActivity(intent);
    }
}