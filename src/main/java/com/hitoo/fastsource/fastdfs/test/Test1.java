
package com.hitoo.fastsource.fastdfs.test;

import java.net.InetSocketAddress;

import com.hitoo.fastsource.common.NameValuePair;
import com.hitoo.fastsource.fastdfs.ClientGlobal;
import com.hitoo.fastsource.fastdfs.StorageClient1;
import com.hitoo.fastsource.fastdfs.StorageServer;
import com.hitoo.fastsource.fastdfs.TrackerClient;
import com.hitoo.fastsource.fastdfs.TrackerGroup;
import com.hitoo.fastsource.fastdfs.TrackerServer;

public class Test1
{
  public static void main(String args[])
  {
  	try
  	{
		ClientGlobal.init("fdfs_client.conf");
		System.out.println("network_timeout=" + ClientGlobal.g_network_timeout + "ms");
		System.out.println("charset=" + ClientGlobal.g_charset);
  		
		TrackerGroup tg = new TrackerGroup(new InetSocketAddress[]{new InetSocketAddress("192.168.0.196", 22122)});
		TrackerClient tc = new TrackerClient(tg);
		
		TrackerServer ts = tc.getConnection();
		if (ts == null)
		{
			System.out.println("getConnection return null");
			return;
		}

		StorageServer ss = tc.getStoreStorage(ts);
		if (ss == null)
		{
			System.out.println("getStoreStorage return null");
		}
		
		StorageClient1 sc1 = new StorageClient1(ts, ss);
		
		NameValuePair[] meta_list = null;  //new NameValuePair[0];
		String item = "c:/windows/system32/notepad.exe";
		String fileid = sc1.upload_file1(item, "exe", meta_list); //�����쳣
		
		System.out.println("Upload local file "+item+" ok, fileid="+fileid);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	
	}
}
