package traceip.sanjogpractise.com.traceip.Utils;



import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import traceip.sanjogpractise.com.traceip.R;

public class DialogUtility {

	/**
	 * returns common message dialog
	 * @param pContext app context
	 * @param pTitle title if u need any, pass null if u want 'message' as title
	 * @param pMsg body of the dialog
	 * @param pOK OK button text, pass null for 'OK'
	 * @return constructed dialog or NULL if the pmsg is null
	 */
	public static Dialog getOKDialog(Context pContext, String pTitle,String pMsg, String pOK) {
		if(pMsg == null) return null;
		AlertDialog.Builder lBuilder = new AlertDialog.Builder(pContext);
		if(pTitle == null){
			lBuilder.setTitle(pContext.getResources().getString(R.string.message_text));
		} else{
			lBuilder.setTitle(pTitle);	
		}
		lBuilder.setMessage(pMsg);
		if(pOK == null){
			lBuilder.setPositiveButton(pContext.getResources().getString(R.string.ok_text), null);
		} else{
			lBuilder.setPositiveButton(pOK, null);	
		}
		return lBuilder.create();
	}
	
	public static Dialog getProgressDialog(Context pContext, String pMsgAny) {
		LayoutInflater inflater = (LayoutInflater)pContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View lView = inflater.inflate(R.layout.progress_dialog, null, false);
		if(pMsgAny != null) {
			((TextView)lView.findViewById(R.id.progress_text)).setText(pMsgAny);	
		} else {
			((TextView)lView.findViewById(R.id.progress_text)).setVisibility(View.GONE);
		}
		
		Dialog lDialog = new Dialog(pContext, android.R.style.Theme_Translucent_NoTitleBar);
		lDialog.setContentView(lView);
		return lDialog;
	}
}

