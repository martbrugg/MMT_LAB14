package mmt_image;

import java.util.Arrays;

public class MMTRaster {
	int[] raster;
	int size;
	int maxOffset;
	int badCount;
	
	public MMTRaster(int size) {
		this.size=size;
		maxOffset=(size/2);
		raster = new int[size*size];
	}
	
	
	public void setRaster(MMTImage img, int posX, int posY){
		int x=0;
		int y=0;
		int tmpPosX;
		int tmpPosY;
		badCount = 0;
		for(int i=0; i<size*size;i++){
			tmpPosX = posX-maxOffset+x;
			tmpPosY = posY-maxOffset+y;
			//System.out.println("XPos: "+ tmpPosX + "YPos:"+ tmpPosY);
			//System.out.println("x: "+ x + " y:"+ y);
			//System.out.println(img.getWidth());
			if(tmpPosX < 0 || tmpPosY < 0 || tmpPosX >= img.getWidth() || tmpPosY >= img.getHeight()){
				raster[i]=-1;
				badCount++;
			}
			else{
				raster[i]=img.getPixel(tmpPosX, tmpPosY);	
			}
			x++;
			
			if (x>=size){
				x=0;
				y++;
			}
	}
		//System.out.println("BadCount" + badCount);
}
	public int getAverage(){
		int cnt=0;
		int sum=0;
		for(int i=0; i<raster.length;i++){
			if(raster[i] >=0){
				sum+=raster[i];
				cnt++;	
			}
		}
		return sum/cnt;
		
	}
	
	public int getMedian(){
		
		Arrays.sort(raster);
		int len=raster.length-badCount;
		//System.out.println("Len" + len);
		int median;
		if(len%2==0){
			//System.out.println("even len");
			median = (raster[len/2+badCount]+raster[len/2+1+badCount])/2;
			
		}
		
		else{
			median= raster[(len+1)/2+badCount];
			
			
		}
		return median;
	}
		
	public int getLaplacian4(double factor){
			
			int sum=0;
			int cnt=0;
			
			
			for(int i=0; i<raster.length;i++){
				if (i%2!=0 && raster[i] != -1){
					sum+= raster[i]*-1;
					cnt++;
				}
			}
			sum = cnt*raster[4]+sum;
			
			if(sum<0){
				sum=0;
			}
			
			if(sum>255){
				sum=255;
			}
			return  Combine(raster[4], sum, factor);
	}
	public int getLaplacian8(double factor){
		
		int sum=0;
		int cnt=0;
		
		
		for(int i=0; i<raster.length;i++){
			if (i!=4 && raster[i] != -1){
				sum+= raster[i]*-1;
				cnt++;
			}
		}
		sum = cnt*raster[4]+sum;
		
		if(sum<0){
			sum=0;
		}
		
		if(sum>255){
			sum=255;
		}
		return  Combine(raster[4], sum, factor);
	
	
}
	
	public int Combine(int pix, int grad, double factor){
		if (factor > 0){
			return Clipping((int) (pix + grad * factor));	
		}
		else {
			return grad;
		}
		
	}
	
public int getSobel( double factor){
		
		
		int[] xIndex = {0,2,3,5,6,8};
		int[] yIndex = {0,6,1,7,2,8};
		int[] fac= {1,-1,2,-2,1,-1};
		int gX=0;
		int gY=0;
		int g;
		int cnt=0;
		
		for(int index : xIndex){
			if (raster[index] != -1){
				gX+= raster[index]*fac[cnt];
				
			}
			cnt++;
		}
		cnt = 0;
		for(int index : yIndex){
			if (raster[index] != -1){
				gY+= raster[index]*fac[cnt];
				
			}
			cnt++;
		}
		g = (int) Math.sqrt(Math.pow(gX, 2)+Math.pow(gX, 2));
		g = Clipping(g);
		return Combine(raster[4], g, factor);
	
}

public static int Clipping(int val){
	if(val<0){
		return 0;
	}
	
	else if(val>255){
		return 255;
	}
	
	else {
		return val;
	}
}
}
