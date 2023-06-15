import java.util.Scanner;		// gerekli import işlemleri yapılır
import java.lang.System;


public class IstasyonBirak extends Istasyon{		// istasyon ata sınıfından kalıtımla çoğaltılır

	public IstasyonBirak() {
		super();
		
	}

	public IstasyonBirak(String sehir, String istasyon) {
		super(sehir, istasyon);
		
	}
	
	Scanner sc=new Scanner(System.in);
	

	  public void ist() {		// override işlemi yapılır

	    	 int sec;			// gerekli değişkenler tanımlanır
	    	 int s;


			 // gerekli istasyon verileri alınır
	    	 
	    	 System.out.println("Aracı teslim etmek istediğiniz şehiri seçiniz...");
	    	 System.out.println("1)İstanbul\n2)Ankara\n3)İzmir");
	    	 sec=sc.nextInt();
	    	 
	    	 if(sec==1) {
	    		 System.out.println("'İstanbul' şehrinde bulunan istasyonlarımız:\n1)İstanbul Havalimanı\n2)Sabiha Gökçen Havalimanı\n3)Taksim");
	    	     System.out.println("Tercih etmek istediğiniz istasyonu seçiniz..");
	    	     s=sc.nextInt();
				 if(s == 1 || s == 2 || s == 3 ){
					System.out.println("Seçimleriniz başarıyla gerçekleşti...");
				
				} else {
					// uygun seçim yapılmadıysa işlem sonlandırılır
					System.out.println("Hatali Giris Yaptiniz!");
					System.out.println("Islem sonlandiriliyor");
					System.exit(0); 
				}
	    	 }
	    	 else if(sec==2) {
	    		 System.out.println("'Ankara' şehrinde bulunan istasyonlarımız:\n1)Esenboğa Havalimanı\n2)YHT Gar\n");
	    		 System.out.println("Tercih etmek istediğiniz istasyonu seçiniz..");
	    	     s=sc.nextInt();
				 if(s == 1 || s == 2){
					System.out.println("Seçimleriniz başarıyla gerçekleşti...");
				
				} else {
					// uygun seçim yapılmadıysa işlem sonlandırılır
					System.out.println("Hatali Giris Yaptiniz!");
					System.out.println("Islem sonlandiriliyor");
					System.exit(0); 
				}
	    	 }
	    	 else if(sec==3) {
	    		 System.out.println("'İzmir' şehrinde bulunan istasyonlarımız:\n1)Adnan Menderes Havalimanı\n2)Bornova\n3)Göztepe\n");
	    		 System.out.println("Tercih etmek istediğiniz istasyonu seçiniz..");
	    	     s=sc.nextInt();
				 if(s == 1 || s == 2 || s == 3 ){
					System.out.println("Seçimleriniz başarıyla gerçekleşti...");
				
				} else {
					// uygun seçim yapılmadıysa işlem sonlandırılır
					System.out.println("Hatali Giris Yaptiniz!");
					System.out.println("Islem sonlandiriliyor");
					System.exit(0); 
				}
	    	 } 
			 else{

				// uygun seçim yapılmadıysa işlem sonlandırılır
				System.out.println("Hatali Giris Yaptiniz!");
				System.out.println("Islem sonlandiriliyor");
				System.exit(0); 
			 }
	    	 
	     
	    	 
	     }
}
