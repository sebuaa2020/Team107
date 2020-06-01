import websocket
import json


key_list = []
map_list = []

def on_message(ws, message):
    #print(ws)
    print("reveive" + message)
    jsonObj = json.loads(message)
    if jsonObj['type'] == 'angle_speed':
        key_list.append(jsonObj['data'])        
    elif jsonObj['type'] == 'stop':
        key_list.append('stop')
    elif jsonObj['type'] == 'map_refresh':
        map_list.append('refresh')

def on_error(ws, error):
    #print(ws)
    print(error)


def on_close(ws):
    #print(ws)
    print("### closed ###")


ws = websocket.WebSocketApp("ws://134.175.14.15:8080/demo/websocket/2",
                            on_message=on_message,
                            on_error=on_error,
                            on_close=on_close)
