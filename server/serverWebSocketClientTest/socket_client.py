import websocket
import time
try:
    import thread
except ImportError:
    import _thread as thread

import json

def on_message(ws, message):
    #print(ws)
    print(time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time())) + ' recv ' + message)


def on_error(ws, error):
    #print(ws)
    print(error)


def on_close(ws):
    #print(ws)
    print("### closed ###")

def on_open(ws):
    def run(*args):
        
        ws.send(r'{"to":"android","from":"robot","type":"angele_speed","data":"13.0 0.2"}')
        time.sleep(1)
        ws.send(r'{"to":"android","from":"robot","type":"angele_speed","data":"12.0 0.2"}')
        time.sleep(1)
        ws.send(r'asdfsadncxoodssa')
        time.sleep(1)
        ws.send(r'sljovcxafasasdas')
        time.sleep(1)
        ws.send(r'{"to":"xxx","from":"xxx","type":"yyy","data":"zzz"}')
    thread.start_new_thread(run, ())
'''

'''
websocket.enableTrace(True)

#模拟安卓客户端
ws = websocket.WebSocketApp("ws://134.175.14.15:8080/demo/websocket/1",
                            on_message=on_message,
                            on_error=on_error,
                            on_close=on_close)

ws.on_open = on_open
ws.run_forever()