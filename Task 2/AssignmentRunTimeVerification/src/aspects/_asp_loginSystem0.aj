package aspects;

import main.RunnerLoggingSystem;

import larva.*;
public aspect _asp_loginSystem0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_loginSystem0.initialize();
}
}
before () : (call(* *.seeAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_loginSystem0.lock){

_cls_loginSystem0 _cls_inst = _cls_loginSystem0._get_cls_loginSystem0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 2/*seeAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 2/*seeAlerts*/);
}
}
before () : (call(* *.validLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_loginSystem0.lock){

_cls_loginSystem0 _cls_inst = _cls_loginSystem0._get_cls_loginSystem0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 0/*validLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 0/*validLogin*/);
}
}
before () : (call(* *.loggingOut(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_loginSystem0.lock){

_cls_loginSystem0 _cls_inst = _cls_loginSystem0._get_cls_loginSystem0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 6/*loggingOut*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 6/*loggingOut*/);
}
}
before () : (call(* *.invalidLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_loginSystem0.lock){

_cls_loginSystem0 _cls_inst = _cls_loginSystem0._get_cls_loginSystem0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 4/*invalidLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 4/*invalidLogin*/);
}
}
}