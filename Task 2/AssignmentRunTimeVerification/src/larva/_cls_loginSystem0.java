package larva;


import main.RunnerLoggingSystem;

import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_loginSystem0 implements _callable{

public static PrintWriter pw; 
public static _cls_loginSystem0 root;

public static LinkedHashMap<_cls_loginSystem0,_cls_loginSystem0> _cls_loginSystem0_instances = new LinkedHashMap<_cls_loginSystem0,_cls_loginSystem0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\isaac\\workspace\\AssignmentRunTimeVerification/src/output_loginSystem.txt");

root = new _cls_loginSystem0();
_cls_loginSystem0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_loginSystem0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;
 public boolean AlertsViewed =false ;
 public boolean loggedIn =false ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_loginSystem0() {
}

public void initialisation() {
}

public static _cls_loginSystem0 _get_cls_loginSystem0_inst() { synchronized(_cls_loginSystem0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_loginSystem0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_loginSystem0_instances){
_performLogic_loginSystemProperty(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_loginSystem0[] a = new _cls_loginSystem0[1];
synchronized(_cls_loginSystem0_instances){
a = _cls_loginSystem0_instances.keySet().toArray(a);}
for (_cls_loginSystem0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_loginSystem0_instances){
_cls_loginSystem0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_loginSystemProperty = 3;

public void _performLogic_loginSystemProperty(String _info, int... _event) {

_cls_loginSystem0.pw.println("[loginSystemProperty]AUTOMATON::> loginSystemProperty("+") STATE::>"+ _string_loginSystemProperty(_state_id_loginSystemProperty, 0));
_cls_loginSystem0.pw.flush();

if (0==1){}
else if (_state_id_loginSystemProperty==2){
		if (1==0){}
		else if ((_occurredEvent(_event,6/*loggingOut*/)) && (loggedIn ==true )){
		loggedIn =false ;

		_state_id_loginSystemProperty = 3;//moving to state logOut
		_goto_loginSystemProperty(_info);
		}
		else if ((_occurredEvent(_event,2/*seeAlerts*/)) && (loggedIn ==true )){
		AlertsViewed =false ;

		_state_id_loginSystemProperty = 1;//moving to state viewAlertsState
		_goto_loginSystemProperty(_info);
		}
}
else if (_state_id_loginSystemProperty==3){
		if (1==0){}
		else if ((_occurredEvent(_event,4/*invalidLogin*/)) && (loggedIn ==false )){
		loggedIn =false ;

		_state_id_loginSystemProperty = 3;//moving to state logOut
		_goto_loginSystemProperty(_info);
		}
		else if ((_occurredEvent(_event,0/*validLogin*/)) && (loggedIn ==false )){
		loggedIn =true ;

		_state_id_loginSystemProperty = 2;//moving to state loggedIn
		_goto_loginSystemProperty(_info);
		}
		else if ((_occurredEvent(_event,2/*seeAlerts*/)) && (loggedIn ==false )){
		AlertsViewed =true ;

		_state_id_loginSystemProperty = 0;//moving to state badCase
		_goto_loginSystemProperty(_info);
		}
}
else if (_state_id_loginSystemProperty==1){
		if (1==0){}
		else if ((_occurredEvent(_event,6/*loggingOut*/)) && (loggedIn ==true )){
		loggedIn =false ;

		_state_id_loginSystemProperty = 3;//moving to state logOut
		_goto_loginSystemProperty(_info);
		}
}
}

public void _goto_loginSystemProperty(String _info){
_cls_loginSystem0.pw.println("[loginSystemProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_loginSystemProperty(_state_id_loginSystemProperty, 1));
_cls_loginSystem0.pw.flush();
}

public String _string_loginSystemProperty(int _state_id, int _mode){
switch(_state_id){
case 2: if (_mode == 0) return "loggedIn"; else return "loggedIn";
case 0: if (_mode == 0) return "badCase"; else return "!!!SYSTEM REACHED BAD STATE!!! badCase "+new _BadStateExceptionloginSystem().toString()+" ";
case 3: if (_mode == 0) return "logOut"; else return "logOut";
case 1: if (_mode == 0) return "viewAlertsState"; else return "viewAlertsState";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}