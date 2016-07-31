package com.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.net.ssl.SSLException;

import org.apache.http.Consts;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class HttpClientTest2 {

    
   public static void main(String[] args) {
        
       try {
           test2();
       } catch (Exception e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
   }
    
    
    
    
    
    
   /**
    * ����1�� ��������uri�����ַ�ʽ��ܷ�������ö��������
    * 
    * HttpClients����client�ľ���һ��ʵ���ࣻ
    * 
    * URIBuilder������Э�飬���������˿ڣ���ѡ������Դ·�����Ͷ����������ѡ��
    * 
    */
   private static void test1() {
        
       CloseableHttpClient client = HttpClients.createDefault();
        
       URI uri = null;
       try {
           uri = new URIBuilder()
           .setScheme("http")
           .setHost("webservice.webxml.com.cn")
           .setPath("/WebServices/MobileCodeWS.asmx/getDatabaseInfo")
           .setParameter("", "")//����������ö������
           .setParameter("", "")
           .setParameter("", "")
           .setParameter("", "")
           .build();
       } catch (URISyntaxException e1) {
           e1.printStackTrace();
       }
        
       //http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx/getDatabaseInfo
       HttpGet get = new HttpGet(uri);
       try {
           CloseableHttpResponse response = client.execute(get);
            
           if(response.getStatusLine().getStatusCode()==200){
                
                
               System.out.println(EntityUtils.toString(response.getEntity()));
                
               //�������ַ�ʽ��ȡ��Ҳ���ԣ�ֻ������EntityUtils�������
               /*InputStream is = response.getEntity().getContent();
               ByteArrayOutputStream os = new ByteArrayOutputStream();
               byte[] buffer = new byte[1024];
               int len=-1;
               while((len = is.read(buffer))!=-1){
                   os.write(buffer,0,len);
               }
               os.close();
               is.close();
               System.out.println(os.size()+new String(os.toByteArray(),"utf-8"));*/
           }
       } catch (ClientProtocolException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
   }
    
    
   /**
    * Ϊuri���м��ܣ������б��ύ��
    * 
    * ���Ӧ����Ҫģ���ύ��HTML���Ĵ������磬��
       Ϊ�˵�¼��WebӦ�ó�����ύ���������ݡ� HttpClient�ṩ��ʵ����
       UrlEncodedFormEntity����ʵ�ָù��̣�
    */
   private static void test2(){
        
       CloseableHttpClient client = HttpClients.createDefault();
        
       HttpPost httppost = new HttpPost("https://passport.baidu.com/v2/api/?login");
        
       //�����������
       List<NameValuePair> list = new ArrayList<NameValuePair>();
       list.add(new BasicNameValuePair("username", "yingma_my"));
       list.add(new BasicNameValuePair("password", "nJdKIQ5pvF5vtQrZXIPjrwAAFw8ksb4lDTc0LK99jrdrXBiGtbWY1gPf41kwRILxFSri6qKyZCtg2X/uSQpm01QR20K70jJhYLp6CUhJdC08CmRcJwb8SkG5Dyn7EBZJshEpeuqAtgxvme9kecVwBIkyELxyiURkXs/blpe7njE="));

       //����url����ʵ�壬����utf-8��ʽ���м��ܣ�
       UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, Consts.UTF_8);
       httppost.setEntity(entity);
       System.out.println(httppost.getURI());
       System.out.println(httppost.getParams().getParameter("wd"));

        
       try {
           CloseableHttpResponse response = client.execute(httppost);
            
           if(response.getStatusLine().getStatusCode()==200){
               System.out.println(EntityUtils.toString(response.getEntity()).length());

               //org.apache.http.util.EntityUtils����Կ��ٴ������������ʵ�����
               System.out.println(EntityUtils.toString(response.getEntity()));
                
           }
       } catch (ClientProtocolException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
    
   }
    
    
   /**
    * �Իص���ʽ�����ؽ��
    * 
    *  ������Ӧ����򵥺����ķ�����ͨ��ʹ��ResponseHandler��
       �ӿڡ��û����ص������ӹ�������⡣��ʹ��һ��
       ResponseHandler��ʱ�������Ƿ�����ִ�гɹ������쳣��HttpClient�����Զ��ͷ����ӡ�
    */
   private static void test3(){
        
       CloseableHttpClient client = HttpClients.createDefault();
        
       //==============================================================
       ResponseHandler<Object> handler = new ResponseHandler<Object>() {
           @Override
           public Object handleResponse(final HttpResponse response) throws IOException {
                
               HttpEntity entity = response.getEntity();
                
               if (entity == null) {
                   throw new ClientProtocolException("���ؽ��Ϊ��");
               }
            
               if(response.getStatusLine().getStatusCode()==200){
                    
                   //��ȡ���ؽ�����ַ��� �磺utf-8  gbk�����������ַ�������ȡ����Ϣ
                   ContentType contentType = ContentType.getOrDefault(entity);
                   Charset charset = contentType.getCharset();
                    
                   InputStreamReader reader = new InputStreamReader(entity.getContent(), charset);
                   BufferedReader br = new BufferedReader(reader);
                   StringBuffer sb = new StringBuffer();
                   char[] buffer = new char[1024];
                   while (br.read(buffer)!=-1) {
                       sb.append(new String(buffer));
                   }
                    
                   return sb.toString();
               }
                
               return null;
                
           }
       };
       //===================================================================
        
       URI uri = null;//����uriʵ��
       try {
           uri = new URIBuilder()
           .setScheme("http")
           .setHost("webservice.webxml.com.cn")
           .setPath("/WebServices/MobileCodeWS.asmx/getDatabaseInfo")
           .setParameter("", "")
           .setParameter("", "")
           .setParameter("", "")
           .build();
            
       } catch (URISyntaxException e) {
           e.printStackTrace();
       }
        
       HttpPost post = new HttpPost(uri);
        
       try {
            
           //handler�ص�
            Object obj = client.execute(post, handler);
             
            System.out.println("���ؽ����"+obj);
            
       } catch (ClientProtocolException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
        
   }
    
    
    
   /**
    *  ���ó����Ӳ��ԣ����ݷ�������Լ�����߿ͻ��˵�Լ�������ó����ӵ�ʱ����
    */
   private static void test4() {
        
       ConnectionKeepAliveStrategy strategy = new DefaultConnectionKeepAliveStrategy() {
            
           /**
            * �����������ã���tomcatΪ������keepAliveTimeout=60000����ʾ��60s���ڣ���������һֱ��������״̬��
            * Ҳ����˵������ͻ���һֱ������������Ҽ��δ����60s��������ӽ�һֱ���֣����60s��δ������ʱ��
            * 
            * getKeepAliveDuration���س�ʱʱ�䣻
            */
           @Override
           public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
                
                
               //���������ָ���˳�ʱʱ�䣬���Է������ĳ�ʱʱ��Ϊ׼
               HeaderElementIterator it = new BasicHeaderElementIterator(response.headerIterator(HTTP.CONN_KEEP_ALIVE));
               while (it.hasNext()) {
                   HeaderElement he = it.nextElement();
                   String param = he.getName();
                   String value = he.getValue();
                   if (value != null && param.equalsIgnoreCase("timeout")) {
                       try {
                           System.out.println("������ָ���ĳ�ʱʱ�䣺" + value + " ��");
                           return Long.parseLong(value) * 1000;
                       } catch (NumberFormatException ignore) {
                           ignore.printStackTrace();
                       }
                   }
               }
                
                
               long keepAlive = super.getKeepAliveDuration(response, context);
                
                // ���������δָ����ʱʱ�䣬��ͻ���Ĭ��30s��ʱ
               if (keepAlive == -1) {
                   keepAlive = 30 * 1000;
               }
                
               return keepAlive;
                
               /*�������webservice.webxml.com.cn��������ʱʱ��5�룬����������ʱʱ��30��
               HttpHost host = (HttpHost) context.getAttribute(HttpClientContext.HTTP_TARGET_HOST);
               if ("webservice.webxml.com.cn".equalsIgnoreCase(host.getHostName())) {
                   keepAlive =  10 * 1000;
               } else {
                   keepAlive =  30 * 1000;
               }*/
                
                
           }
       };
        
        
        
       CloseableHttpClient client = HttpClients.custom().setKeepAliveStrategy(strategy).build();
        
       URI uri = null;//����uriʵ��
       try {
           uri = new URIBuilder()
           .setScheme("http")
           .setHost("webservice.webxml.com.cn")
           .setPath("/WebServices/MobileCodeWS.asmx/getDatabaseInfo")
           .setParameter("", "")
           .build();
            
       } catch (URISyntaxException e) {
           e.printStackTrace();
       }
        
       HttpPost post = new HttpPost(uri);
        
       try {
            
           CloseableHttpResponse response =  client.execute(post);
           if(response.getStatusLine().getStatusCode()==200){
               String result = EntityUtils.toString(response.getEntity());
               System.out.println("���صĽ��====="+result);
           }
            
       } catch (ClientProtocolException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
        
    
        
   }
    
    
   /**
    * ��������������
    * 
    * RequestConfig���ᱣ����context�������У������������������н��д��������Թٷ��ĵ�����
    * 
    */
   private void test5(){

        
       CloseableHttpClient client = HttpClients.createDefault();
        
       //������������
       RequestConfig config = RequestConfig.
               custom().
               setSocketTimeout(1000*10).
               setConnectTimeout(1000*10).
               build();
       //==============================================================
       ResponseHandler<Object> handler = new ResponseHandler<Object>() {//�ص�
           @Override
           public Object handleResponse(final HttpResponse response) throws IOException {
                
               HttpEntity entity = response.getEntity();
                
               if (entity == null) {
                   throw new ClientProtocolException( "���ؽ��Ϊ��");
               }
            
               if(response.getStatusLine().getStatusCode()==200){
                   ContentType contentType = ContentType.getOrDefault(entity);
                   Charset charset = contentType.getCharset();
                    
                   InputStreamReader reader = new InputStreamReader(entity.getContent(), charset);
                   BufferedReader br = new BufferedReader(reader);
                   StringBuffer sb = new StringBuffer();
                   char[] buffer = new char[1024];
                   while (br.read(buffer)!=-1) {
                       sb.append(new String(buffer));
                   }
                    
                   return sb.toString();
               }
                
               return null;
                
           }
       };
       //===================================================================
        
       URI uri = null;
       try {
           uri = new URIBuilder()
           .setScheme("http")
           .setHost("webservice.webxml.com.cn")
           .setPath("/WebServices/MobileCodeWS.asmx/getDatabaseInfo")
           .setParameter("", "")
           .setParameter("", "")
           .setParameter("", "")
           .build();
            
       } catch (URISyntaxException e) {
           e.printStackTrace();
       }
        
       HttpPost post = new HttpPost(uri);
        
       post.setConfig(config);//������������
        
       try {
            Object obj = client.execute(post, handler);
             
            System.out.println("���ؽ����"+obj);
            
       } catch (ClientProtocolException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
        
    
   }
    
    
    
   /**
    *  �쳣�ָ����ƣ�
    *  
    *  HttpRequestRetryHandler����ʧ�ܺ󣬿��������Ӧ���쳣������Ӧ�Ĵ����ʩ��
    *  HttpRequestRetryHandler�ӿ���Ҫ�û��Լ�ʵ�֣�
    *  
    */
   private static  void test6(){

       HttpRequestRetryHandler retryHandler = new HttpRequestRetryHandler() {
            
           /**
            * exception�쳣��Ϣ��
            * executionCount������������
            * context��������
            */
           @Override
           public boolean retryRequest(IOException exception, int executionCount,HttpContext context) {

               System.out.println("�����Ӵ�����"+executionCount);
                
               if (executionCount >= 5) {//������Ӵ�������5�Σ��Ͳ������ظ�����
                   return false;
               }
               if (exception instanceof InterruptedIOException) {//io�����ж�
                   return false;
               }
               if (exception instanceof UnknownHostException) {//δ�ҵ�����
                   // Unknown host
                   return false;
               }
               if (exception instanceof ConnectTimeoutException) {//���ӳ�ʱ
                   return true;
               }
               if (exception instanceof SSLException) {
                   // SSL handshake exception
                   return false;
               }
               HttpClientContext clientContext = HttpClientContext.adapt(context);
                
               HttpRequest request = clientContext.getRequest();
                
               boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
                
               if (idempotent) {
                   // Retry if the request is considered idempotent
                   return true;
               }
               return false;
           }
       };
        
        
       CloseableHttpClient client = HttpClients.custom().setRetryHandler(retryHandler).build();
        
       RequestConfig config = RequestConfig.
               custom().
               setSocketTimeout(1000*10).
               setConnectTimeout(1000*10).
               build();
        
       HttpPost post = new HttpPost("http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx/getDatabaseInfo");
        
       post.setConfig(config);
        
       try {
           HttpResponse response = client.execute(post);
           HttpEntity entity = response.getEntity();
            
           ContentType contentType = ContentType.getOrDefault(entity);
           Charset charset = contentType.getCharset();

           InputStreamReader reader = new InputStreamReader(entity.getContent(), charset);
           BufferedReader br = new BufferedReader(reader);
           StringBuffer sb = new StringBuffer();
           char[] buffer = new char[1024];
           while (br.read(buffer) != -1) {
               sb.append(new String(buffer));
           }

           System.out.println("���صĽ����"+sb.toString());

       } catch (ClientProtocolException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
        
   }
    
    
   /**
    *  HTTP�������������ִ������֮ǰ����HttpRequest �� HttpContext��
    */
   private static void test7() throws ClientProtocolException, IOException{
        
       HttpRequestInterceptor requestInterceptor = new HttpRequestInterceptor() {
           /**
            * ��������
            * ����ǿͻ��ˣ���������ڷ�������֮ǰִ�У�
            * ����Ƿ���������������ڽ��յ�������֮ǰִ�У�
            */
           public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
               AtomicInteger count = (AtomicInteger) context.getAttribute("count");
               request.addHeader("count", Integer.toString(count.getAndIncrement()));
           }
       };
        
        
       CloseableHttpClient httpclient = HttpClients.
                       custom().
                       addInterceptorLast(requestInterceptor).
                       build();
        
        
       AtomicInteger count = new AtomicInteger(1);
       HttpClientContext context = HttpClientContext.create();
       context.setAttribute("count", count);
       HttpGet httpget = new HttpGet("http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx/getDatabaseInfo");
        
       for (int i = 0; i < 10; i++) {
           CloseableHttpResponse response = httpclient.execute(httpget,context);
           try {
                
               HttpEntity entity = response.getEntity();
//             System.out.println(EntityUtils.toString(entity));
                
           } finally {
               response.close();
           }
       }
   }
    
    
    
    
   /**
    * 
    *  httpclient���Զ������ض��� 
    *  
    *  301 �����ض���,���߿ͻ����Ժ�Ӧ���µ�ַ����.
       302 ��ΪHTTP1.0�ı�׼,��ǰ����Moved Temporarily ,���ڽ�Found. ����ʹ��ֻ��Ϊ�˼����Ե�  ����,����PHP��Ĭ��Location�ض����õ�Ҳ��302.
       ����HTTP 1.1 ��303 ��307��Ϊ��ϸ�Ĳ���,��ʵ�Ƕ�302��ϸ��
       303������POST��������ʾ�����Ѿ��������ͻ��˿��Խ���ʹ��GET����ȥ����Location���URI��
       307������POST���󣬱�ʾ����û�б������ͻ���Ӧ����Location���URI���·���POST����
    */
   private static void test8() throws ClientProtocolException, IOException,
           URISyntaxException {

       LaxRedirectStrategy redirectStrategy = new LaxRedirectStrategy();
       CloseableHttpClient httpclient = HttpClients.custom().setRedirectStrategy(redirectStrategy).build();

       HttpClientContext context = HttpClientContext.create();
       HttpGet httpget = new HttpGet("http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx/getDatabaseInfo");
       CloseableHttpResponse response = httpclient.execute(httpget, context);
       try {
           HttpHost target = context.getTargetHost();
           List<URI> redirectLocations = context.getRedirectLocations();
           URI location = URIUtils.resolve(httpget.getURI(), target, redirectLocations);
           System.out.println("Final HTTP location: " + location.toASCIIString());
       } finally {
           response.close();
       }
   }
    
    
    
    
}
