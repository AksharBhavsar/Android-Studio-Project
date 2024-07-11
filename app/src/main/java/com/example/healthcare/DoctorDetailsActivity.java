package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Dr.Deepa Soni", "Hospital Address : Shahibaug", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name : Dr.Prashant Shah", "Hospital Address : Nikol", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Dr.Ravi Jain", "Hospital Address : Maninagar", "Exp : 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Dr.Ayush Shah", "Hospital Address : Vastral", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Dr.Prachi", "Hospital Address : Bapunagar", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Dr.Naman Jain", "Hospital Address : Ambawadi", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name : Dr.Amit Ismaili", "Hospital Address : Vatva", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Dr.Dhiren Rathod", "Hospital Address : Sabarmati", "Exp : 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Dr.Kamal Jani", "Hospital Address : Usmanpura", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Dr.Jay Gandhi", "Hospital Address : Naroda", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Dr.Tanish Modi", "Hospital Address : Naroda", "Exp : 4yrs", "Mobile No:9898989898", "200"},
                    {"Doctor Name : Dr.Sejal Patel", "Hospital Address : Sola", "Exp : 5yrs", "Mobile No:7898989898", "300"},
                    {"Doctor Name : Dr.Hitesh Shah", "Hospital Address : Ranip", "Exp : 7yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Dr.Akshar Bhavsar", "Hospital Address : Odhav", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Dr.Akshay Bhavsar", "Hospital Address : Ambawadi", "Exp : 7yrs", "Mobile No:7798989898", "600"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Dr.Vikki Shah", "Hospital Address : Ranip", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name : Dr.Kaushal Gandhi", "Hospital Address : Vasna", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Dr.Jaimin Dave", "Hospital Address : Usmanpura", "Exp : 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Dr.Avinash Shah", "Hospital Address : Nava Vadaj", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Dr.Jwalant Shah", "Hospital Address : Ghatlodia", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Dr.Pritesh Modi", "Hospital Address : Gota", "Exp : 5yrs", "Mobile No:9898989898", "1600"},
                    {"Doctor Name : Dr.Suresh Shah", "Hospital Address : Sarangpur", "Exp : 15yrs", "Mobile No:7898989898", "1900"},
                    {"Doctor Name : Dr.Pravin Patel", "Hospital Address : Paldi", "Exp : 8yrs", "Mobile No:8898989898", "1300"},
                    {"Doctor Name : Dr.Rohit Shah", "Hospital Address : Bopal", "Exp : 6yrs", "Mobile No:9898000000", "1500"},
                    {"Doctor Name : Dr.Ram Patel", "Hospital Address : Ring Road", "Exp : 7yrs", "Mobile No:7798989898", "1800"}
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonBMCartBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put( "line1", doctor_details[i][0]);
            item.put( "line2", doctor_details[i][1]);
            item.put( "line3", doctor_details[i][2]);
            item.put( "line4", doctor_details[i][3]);
            item.put( "line5", "Cons Fees:"+doctor_details[i][4]+"/-");
            list.add( item );
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewBMCart);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}