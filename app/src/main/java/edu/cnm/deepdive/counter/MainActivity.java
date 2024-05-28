package edu.cnm.deepdive.counter;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import edu.cnm.deepdive.counter.databinding.ActivityMainBinding;
import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

  private static final String TALLY_KEY = "tally";

  private int tally;
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (savedInstanceState != null) {
      tally = savedInstanceState.getInt(TALLY_KEY);
    }

    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    binding.increment.setOnClickListener((v) -> MainActivity.this.updateCount(tally + 1));

    binding.reset.setOnClickListener((v) -> updateCount(0));

    updateCount(tally);
  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putInt(TALLY_KEY, tally);
  }

  private void updateCount(int value) {
    tally = value;
    binding.count.setText(String.valueOf(tally));
  }
}