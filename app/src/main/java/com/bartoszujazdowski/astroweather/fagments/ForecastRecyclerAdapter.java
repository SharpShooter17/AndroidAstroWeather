package com.bartoszujazdowski.astroweather.fagments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bartoszujazdowski.astroweather.ImageController;
import com.bartoszujazdowski.astroweather.R;
import com.bartoszujazdowski.astroweather.SettingsSingleton;
import com.bartoszujazdowski.astroweather.yahooWeather.YahooWeatherImageService;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather.Forecast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ForecastRecyclerAdapter extends RecyclerView.Adapter< ForecastRecyclerAdapter.ViewHolder > {

    private List<Forecast> forecasts = new ArrayList<>();
    Context context;

    @Override
    public ForecastRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Forecast forecast = this.forecasts.get(position);

        holder.itemImage.setImageBitmap(ImageController.getImage(Integer.parseInt(forecast.getCode())));
        holder.itemDate.setText( forecast.getDate() + " - " + forecast.getDay() );
        holder.itemTemp.setText( forecast.getLow() + SettingsSingleton.getInstance().getUnits().toString().toUpperCase() + " - " + forecast.getHigh() + SettingsSingleton.getInstance().getUnits().toString().toUpperCase());
    }

    @Override
    public int getItemCount() {
        return forecasts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemDate;
        TextView itemTemp;
        ImageView itemImage;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemDate = itemView.findViewById(R.id.itemDate);
            this.itemTemp = itemView.findViewById(R.id.itemTemp);
            this.itemImage = itemView.findViewById(R.id.itemImage);
            this.parentLayout = itemView.findViewById(R.id.item);
        }
    }
}
