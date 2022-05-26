package webDriverActions;

import javax.naming.ldap.ExtendedRequest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


	public class ListenerSansExtent implements ITestListener{
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		//System.out.println("la methode est passée en succes : "+result.getMethod().getMethodName());
		System.out.println("la methode est passée en succes : "+result.getName());
		

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		//System.out.println("la methode est passée en erreur : "+result.getMethod().getMethodName());
		System.out.println("la methode est passée en succes : "+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
		System.out.println("la methode est toStart : "+context.getClass().getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		System.out.println("la methode est finish : "+context.getClass().getName());
	}

}
