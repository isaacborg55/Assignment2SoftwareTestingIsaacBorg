package aspects;

import main.MarketAlertUMAlerts;

import larva.*;
public aspect _asp_MarketAlertUMAlerts0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_MarketAlertUMAlerts0.initialize();
}
}
before () : (call(* *.sendBadAlert(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_MarketAlertUMAlerts0.lock){

_cls_MarketAlertUMAlerts0 _cls_inst = _cls_MarketAlertUMAlerts0._get_cls_MarketAlertUMAlerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 10/*sendBadAlert*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 10/*sendBadAlert*/);
}
}
before () : (call(* *.clearAllAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_MarketAlertUMAlerts0.lock){

_cls_MarketAlertUMAlerts0 _cls_inst = _cls_MarketAlertUMAlerts0._get_cls_MarketAlertUMAlerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 12/*clearAllAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 12/*clearAllAlerts*/);
}
}
before () : (call(* *.sendGoodAlert(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_MarketAlertUMAlerts0.lock){

_cls_MarketAlertUMAlerts0 _cls_inst = _cls_MarketAlertUMAlerts0._get_cls_MarketAlertUMAlerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 8/*sendGoodAlert*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 8/*sendGoodAlert*/);
}
}
}