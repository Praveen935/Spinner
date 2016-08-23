package spinner.sample.spinnerexample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private Spinner spinner;
    ArrayList<Item> customerList = new ArrayList<>();
    SpinnerAdapter spinnerAdapter;
    Item selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if(getIntent().hasExtra(MainActivity.EXTRA_INTENT_SELECTED_ITEM)){
            selectedItem = (Item)getIntent().getSerializableExtra(MainActivity.EXTRA_INTENT_SELECTED_ITEM);
        }
        spinner = (Spinner)findViewById(R.id.spinner);
        spinnerAdapter = new SpinnerAdapter(customerList, this);
        spinner.setAdapter(spinnerAdapter);
        new LoadDataTask().execute();
    }

    class LoadDataTask extends AsyncTask<Void, Void, ArrayList<Item>> {

        @Override
        protected ArrayList<Item> doInBackground(Void... voids) {
            String data = loadData();
            customerList = ItemList.parseDate(data).getItems();
            return customerList;
        }

        @Override
        protected void onPostExecute(ArrayList<Item> customerList) {
            if(customerList != null && !customerList.isEmpty()){
                spinnerAdapter.updateDate(customerList);
                if(selectedItem != null){
                    spinner.setSelection(customerList.indexOf(selectedItem));
                }
            }
        }
    }

    private String loadData(){
        URL url = null;
        HttpURLConnection urlConnection = null;
        String data = null;
        try {
            url = new URL("https://www.dropbox.com/s/fjueds9zoxi3ndd/itemsspinner.json?dl=1");
            urlConnection = (HttpURLConnection) url.openConnection();
            data = convertInputStreamToString(urlConnection.getInputStream());
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            urlConnection.disconnect();
        }
        return data;
    }

    private String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null){
            result += line;
        }
        if(null!=inputStream){
            inputStream.close();
        }
        return result;
    }
}
