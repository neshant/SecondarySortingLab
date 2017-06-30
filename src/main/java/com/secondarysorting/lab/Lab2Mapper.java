package com.secondarysorting.lab;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Lab2Mapper extends Mapper<Object, Text, CompositeKeyWritable, NullWritable> {

	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

		String values[] = value.toString().split(",");
		System.out.println(value.toString());
		String zipcode = null;
		String bike_id = null;
		try {
			zipcode = values[10];
			bike_id = values[8];
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (null != zipcode || null != bike_id) {

			CompositeKeyWritable cw = new CompositeKeyWritable(zipcode, bike_id);

			try {

				context.write(cw, NullWritable.get());
			} catch (Exception e) {
				System.out.println(cw);
				// System.out.println(values[10]);
				System.out.println(values[8]);

				System.out.println("" + e.getMessage());

			}

		}

	}

}