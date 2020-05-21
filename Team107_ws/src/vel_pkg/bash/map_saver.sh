#!/bin/bash
read filename
rosrun map_server map_saver -f  ~/Team107/Team107_ws/src/vel_pkg/maps/$filename

