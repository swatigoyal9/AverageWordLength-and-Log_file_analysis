package stubs;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AverageReducer extends Reducer<Text, IntWritable, Text, DoubleWritable> {

  @Override
  public void reduce(Text key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {

    
	  int len = 0;
	  double avg;
	  int count1 = 0;
		
		for (IntWritable value : values) {
			
			len = len + value.get();
			count1 = count1 + 1;
		}
		avg = (double)len/count1;		
		context.write(key, new DoubleWritable(avg));

  }
}