package com.secondarysorting.lab;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

public class CompositeKeyWritable implements Writable,WritableComparable<CompositeKeyWritable> {

	
	private String zipcode;
	private String bikeId;
	
	
	
	public CompositeKeyWritable(){
		
	}
	
	
	public CompositeKeyWritable(String d,String l){
		this.zipcode=d;
		this.bikeId=l;
		
		
	}
	
	public int compareTo(CompositeKeyWritable o) {
		int result =zipcode.compareTo(o.zipcode);
		if (result==0){
			result=bikeId.compareTo(o.bikeId);
		}
		
		return result;
		
	}

	public void write(DataOutput d) throws IOException {
		WritableUtils.writeString(d, zipcode);
		WritableUtils.writeString(d, bikeId);
		
	}

	public void readFields(DataInput di) throws IOException {
		zipcode=WritableUtils.readString(di);
	bikeId=	WritableUtils.readString(di);
		
	}


	
	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getBikeId() {
		return bikeId;
	}


	public void setBikeId(String bikeId) {
		this.bikeId = bikeId;
	}


	public String toString(){
		return (new StringBuilder().append(zipcode).append("\t").append(bikeId).toString());
	}
	
	
	

}
