#!/bin/bash
rosrun map_server map_server -f map
cp ~/map.pgm ~/Team107_ws/src/vel_pkg/maps/
cp ~/map.yaml ~/Team107_ws/src/vel_pkg/maps/
