package larva;


import main.MarketAlertUMAlerts;

import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_MarketAlertUMAlerts0 implements _callable{

public static PrintWriter pw; 
public static _cls_MarketAlertUMAlerts0 root;

public static LinkedHashMap<_cls_MarketAlertUMAlerts0,_cls_MarketAlertUMAlerts0> _cls_MarketAlertUMAlerts0_instances = new LinkedHashMap<_cls_MarketAlertUMAlerts0,_cls_MarketAlertUMAlerts0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\isaac\\workspace\\AssignmentRunTimeVerification/src/output_MarketAlertUMAlerts.txt");

root = new _cls_MarketAlertUMAlerts0();
_cls_MarketAlertUMAlerts0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_MarketAlertUMAlerts0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;
 public int totalnoAlerts =0 ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_MarketAlertUMAlerts0() {
}

public void initialisation() {
}

public static _cls_MarketAlertUMAlerts0 _get_cls_MarketAlertUMAlerts0_inst() { synchronized(_cls_MarketAlertUMAlerts0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_MarketAlertUMAlerts0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_MarketAlertUMAlerts0_instances){
_performLogic_MarketAlertUMAlertsProperty(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_MarketAlertUMAlerts0[] a = new _cls_MarketAlertUMAlerts0[1];
synchronized(_cls_MarketAlertUMAlerts0_instances){
a = _cls_MarketAlertUMAlerts0_instances.keySet().toArray(a);}
for (_cls_MarketAlertUMAlerts0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_MarketAlertUMAlerts0_instances){
_cls_MarketAlertUMAlerts0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_MarketAlertUMAlertsProperty = 7;

public void _performLogic_MarketAlertUMAlertsProperty(String _info, int... _event) {

_cls_MarketAlertUMAlerts0.pw.println("[MarketAlertUMAlertsProperty]AUTOMATON::> MarketAlertUMAlertsProperty("+") STATE::>"+ _string_MarketAlertUMAlertsProperty(_state_id_MarketAlertUMAlertsProperty, 0));
_cls_MarketAlertUMAlerts0.pw.flush();

if (0==1){}
else if (_state_id_MarketAlertUMAlertsProperty==5){
		if (1==0){}
		else if ((_occurredEvent(_event,8/*sendGoodAlert*/)) && (totalnoAlerts <5 )){
		totalnoAlerts ++;

		_state_id_MarketAlertUMAlertsProperty = 5;//moving to state alertSent
		_goto_MarketAlertUMAlertsProperty(_info);
		}
		else if ((_occurredEvent(_event,12/*clearAllAlerts*/))){
		totalnoAlerts =0 ;

		_state_id_MarketAlertUMAlertsProperty = 6;//moving to state alertsCleared
		_goto_MarketAlertUMAlertsProperty(_info);
		}
		else if ((_occurredEvent(_event,10/*sendBadAlert*/))){
		totalnoAlerts ++;

		_state_id_MarketAlertUMAlertsProperty = 4;//moving to state badCase
		_goto_MarketAlertUMAlertsProperty(_info);
		}
		else if ((_occurredEvent(_event,8/*sendGoodAlert*/)) && (totalnoAlerts ==5 )){
		totalnoAlerts ++;

		_state_id_MarketAlertUMAlertsProperty = 4;//moving to state badCase
		_goto_MarketAlertUMAlertsProperty(_info);
		}
}
else if (_state_id_MarketAlertUMAlertsProperty==7){
		if (1==0){}
		else if ((_occurredEvent(_event,8/*sendGoodAlert*/)) && (totalnoAlerts <5 )){
		totalnoAlerts ++;

		_state_id_MarketAlertUMAlertsProperty = 5;//moving to state alertSent
		_goto_MarketAlertUMAlertsProperty(_info);
		}
		else if ((_occurredEvent(_event,12/*clearAllAlerts*/))){
		totalnoAlerts =0 ;

		_state_id_MarketAlertUMAlertsProperty = 6;//moving to state alertsCleared
		_goto_MarketAlertUMAlertsProperty(_info);
		}
		else if ((_occurredEvent(_event,10/*sendBadAlert*/))){
		totalnoAlerts ++;

		_state_id_MarketAlertUMAlertsProperty = 4;//moving to state badCase
		_goto_MarketAlertUMAlertsProperty(_info);
		}
}
else if (_state_id_MarketAlertUMAlertsProperty==6){
		if (1==0){}
		else if ((_occurredEvent(_event,12/*clearAllAlerts*/))){
		totalnoAlerts =0 ;

		_state_id_MarketAlertUMAlertsProperty = 6;//moving to state alertsCleared
		_goto_MarketAlertUMAlertsProperty(_info);
		}
		else if ((_occurredEvent(_event,10/*sendBadAlert*/))){
		totalnoAlerts ++;

		_state_id_MarketAlertUMAlertsProperty = 4;//moving to state badCase
		_goto_MarketAlertUMAlertsProperty(_info);
		}
		else if ((_occurredEvent(_event,8/*sendGoodAlert*/)) && (totalnoAlerts ==0 )){
		totalnoAlerts ++;

		_state_id_MarketAlertUMAlertsProperty = 5;//moving to state alertSent
		_goto_MarketAlertUMAlertsProperty(_info);
		}
}
else if (_state_id_MarketAlertUMAlertsProperty==4){
		if (1==0){}
		else if ((_occurredEvent(_event,8/*sendGoodAlert*/)) && (totalnoAlerts >=5 )){
		totalnoAlerts ++;

		_state_id_MarketAlertUMAlertsProperty = 4;//moving to state badCase
		_goto_MarketAlertUMAlertsProperty(_info);
		}
		else if ((_occurredEvent(_event,10/*sendBadAlert*/))){
		totalnoAlerts ++;

		_state_id_MarketAlertUMAlertsProperty = 4;//moving to state badCase
		_goto_MarketAlertUMAlertsProperty(_info);
		}
		else if ((_occurredEvent(_event,12/*clearAllAlerts*/))){
		totalnoAlerts =0 ;

		_state_id_MarketAlertUMAlertsProperty = 6;//moving to state alertsCleared
		_goto_MarketAlertUMAlertsProperty(_info);
		}
}
}

public void _goto_MarketAlertUMAlertsProperty(String _info){
_cls_MarketAlertUMAlerts0.pw.println("[MarketAlertUMAlertsProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_MarketAlertUMAlertsProperty(_state_id_MarketAlertUMAlertsProperty, 1));
_cls_MarketAlertUMAlerts0.pw.flush();
}

public String _string_MarketAlertUMAlertsProperty(int _state_id, int _mode){
switch(_state_id){
case 5: if (_mode == 0) return "alertSent"; else return "alertSent";
case 7: if (_mode == 0) return "startApi"; else return "startApi";
case 4: if (_mode == 0) return "badCase"; else return "!!!SYSTEM REACHED BAD STATE!!! badCase "+new _BadStateExceptionMarketAlertUMAlerts().toString()+" ";
case 6: if (_mode == 0) return "alertsCleared"; else return "alertsCleared";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}