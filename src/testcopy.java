import java.io.BufferedReader;
import java.io.FileNotFoundException;  
import java.io.FileReader;  
import java.io.IOException;  
import java.util.Iterator;  
import java.util.LinkedHashMap;

import org.apache.cassandra.cli.CliParser.newColumnFamily_return;
import org.json.simple.JSONArray;  
import org.json.simple.JSONObject;  
import org.json.simple.parser.JSONParser;  
import org.json.simple.parser.ParseException;  
/* 
 * @Author : Arpit Mandliya 
 */  
public class testcopy {  
  
 public static void main(String[] args) {  
  
  JSONParser parser = new JSONParser();  
  
  try {  
	  BufferedReader br= new BufferedReader(new FileReader("/home/lovlean/Documents/cloud/pro/test.json"));  
  //String tt="{'fields':[{'id':'a','label':'S. No','type':'string'},{'id':'b','label':'District','type':'string'},{'id':'c','label':'2004 to 2005 (In Rupees)','type':'string'},{'id':'d','label':'2005 to 2006 (In Rupees)','type':'string'},{'id':'e','label':'2006 to 2007 (In Rupees)','type':'string'},{'id':'f','label':'2007 to 2008 (In Rupees)','type':'string'},{'id':'g','label':'2008 to 2009 (In Rupees)','type':'string'},{'id':'h','label':'2009 to 2010 (In Rupees)','type':'string'},{'id':'i','label':'2010 to 2011 (In Rupees)','type':'string'},{'id':'j','label':'2011 to 2012 (P) (In Rupees)','type':'string'},{'id':'k','label':'2012 to 2013 (Q) (In Rupees)','type':'string'}],'data':[['1','Sheopur','11916','12601','13627','15049','17865','20165','22272','28031','32618'],['2','Morena','11049','11994','13469','14890','18218','19906','23259','27424','31728']-,['3','Bhind','10063','11472','12270','13839','18206','20572','22513','25987','31516'],['4','Gwalior','21569','23237','26267','28548','36063','40138','47143','54400','62667'],['5','Datia','13021','14659','16152','17593','21993','25386','28673','33862','43082'],['6','Shivpuri','11419','12274','13067','13611','17512','19891','21612','28044','31966'],['7','Guna','12615','14030','15793','17129','21287','24010','26761','32547','40641'],['8','Tikamgarh','10618','11057','11822','12653','17361','18907','20217','25381','29656'],['9','Chhatarpur','11886','12693','13215','14282','18258','20238','23298','27860','31919'],['10','Panna','11343','12320','13141','14511','17213','19508','22858','27144','31389'],['11','Sagar','13291','14563','16694','18087','22538','25718','28146','33221','39949'],['12','Damoh','13351','14813','17147','18468','23022','25727','26978','31291','37397'],['13','Satna','12927','14068','15778','17153','20656','23240','25864','30338','35753'],['14','Rewa','10523','11443','12956','14015','16599','18107','20624','24747','29866'],['15','Umaria','11047','12070','13308','14696','16357','18417','22467','25602','31298'],['16','Shahadol','16746','17992','19696','21634','26361','28620','32249','36645','42758'],['17','Sidhi','21588','21957','23833','25492','30831','33840','37939','39857','45961'],['18','Neemuch','17841','18187','20840','22532','26892','29302','35651','39410','48424'],['19','Mandsaur','17314','16834','20619','21612','25588','28461','32327','39562','47940'],['20','Ratlam','18001','18857','22362','24587','28505','32001','34971','41453','50529'],['21','Ujjain','19709','21299','25425','27532','32642','38195','40868','47808','57824'],['22','Shajapur','13684','14364','16608','17895','21002','24873','27526','31607','37699'],['23','Dewas','14282','15543','18272','20006','23156','27094','29220','35930','43550'],['24','Jhabua','9261','10156','11102','12583','16254','18058','20542','25734','31316'],['25','Dhar','13256','13822','16529','18682','22613','25688','28385','33275','39297'],['26','Indore','34442','36800','43257','48931','58296','65382','74034','86898','99425'],['27','Khargaone','11449','11819','13820','15283','17585','20345','24298','29898','32266'],['28','Barwani','9433','9845','11307','12315','15412','17409','20536','26082','32776'],['29','Khandwa','13070','14060','16030','17769','20101','22266','26199','32546','39726'],['30','Rajgarh','12721','13516','15117','16661','19725','23077','25467','29428','36010'],['31','Vidisha','13806','14690','17092','17894','22926','26611','29507','32026','38446'],['32','Bhopal','28265','31082','36355','41411','46874','53444','61525','70897','80784'],['33','Sehore','13379','14405','15834','17162','20335','25101','27313','31207','36529'],['34','Raisen','12944','14224','16522','18038','21834','25254','25730','31550','38782'],['35','Betul','13530','14672','17404','18185','22116','25644','29990','33045','39954'],['36','Harda','13994','18312','21170','24249','27754','33331','40503','42997','50480'],['37','Hoshangabad','18418','20421','24457','27694','31271','36430','41917','46396','54027'],['38','Katni','15812','17482','19420','21317','25447','27011','31435','37765','43991'],['39','Jabalpur','21890','23357','27402','30039','39794','44971','53365','61715','72002'],['40','Narsinghpur','13466','14526','16894','18148','21457','25097','26659','30001','36718'],['41','Dindori','9193','10126','11161','12954','15621','18016','21350','26644','35172'],['42','Mandla','9709','10590','11444','12646','15461','16702','20119','22757','25659'],['43','Chhindwara','17448','18638','21536','23982','27357','33137','37718','44452','54745'],['44','Seoni','11560','13119','14988','16578','19559','22070','26272','31070','39570'],['45','Balaghat','13019','14555','16351','18854','22514','24920','28512','32253','39928']]}";
  String xyz=br.readLine();
	  Object obj = parser.parse(xyz);  
  
   JSONObject jsonObject = (JSONObject) obj;  
  
   JSONArray fields=(JSONArray) jsonObject.get("fields");
   LinkedHashMap<String, String> tableObject =new LinkedHashMap<String, String>();
   //System.out.println("Name Of Country: "+nameOfCountry);  
  
 //  long population = (long) jsonObject.get("Population");  
   //System.out.println("Population: "+population);  
  
 //  System.out.println("States are :");  
   //JSONArray listOfStates = (JSONArray) jsonObject.get("States");  
   Iterator< JSONObject > iterator = fields.iterator();  
   while (iterator.hasNext()) { 
	  
	   JSONObject jj= (JSONObject)iterator.next();
	   System.out.println(jj.get("label")+" "+jj.get("type"));
	   tableObject.put((String)jj.get("label"), (String)jj.get("type"));  
   }  
   //jsonObject = (JSONObject) obj;  
   
   JSONArray data=(JSONArray) jsonObject.get("data");
   Iterator< JSONArray > iterator1 = data.iterator();
   while (iterator1.hasNext()) { 
	  
	  JSONArray jj= (JSONArray)iterator1.next();
	  StringBuilder sb=new StringBuilder(jj.toString());
	  sb.deleteCharAt(0);
	  sb.deleteCharAt(sb.length()-1);
	   System.out.println(sb);  
	  
   }  
  
  } catch (FileNotFoundException e) {  
   e.printStackTrace();  
  } catch (IOException e) {  
   e.printStackTrace();  
  } catch (ParseException e) {  
   e.printStackTrace();  
  }  
  
 }  
}