/*
https://cdn.staticfile.org/echarts/3.5.0/echarts.common.min.js(正式版昨天温度不变灰)

https://mat1.gtimg.com/pingjs/ext2020/test2017/echarts.js（修改版本昨天温度可便会）

*/

var data = {
  forecast_24h: {
    0: {
      day_weather: "多云",
      day_weather_code: "01",
      day_weather_short: "多云",
      day_wind_direction: "微风",
      day_wind_direction_code: "0",
      day_wind_power: "3",
      day_wind_power_code: "0",
      max_degree: "18",
      min_degree: "10",
      night_weather: "小雨",
      night_weather_code: "07",
      night_weather_short: "小雨",
      night_wind_direction: "微风",
      night_wind_direction_code: "0",
      night_wind_power: "3",
      night_wind_power_code: "0",
      time: "2018-02-25"
    },
    1: {
      day_weather: "小雨",
      day_weather_code: "07",
      day_weather_short: "小雨",
      day_wind_direction: "微风",
      day_wind_direction_code: "0",
      day_wind_power: "3",
      day_wind_power_code: "0",
      max_degree: "13",
      min_degree: "9",
      night_weather: "小雨",
      night_weather_code: "07",
      night_weather_short: "小雨",
      night_wind_direction: "微风",
      night_wind_direction_code: "0",
      night_wind_power: "3",
      night_wind_power_code: "0",
      time: "2018-02-26"
    },
    2: {
      day_weather: "多云",
      day_weather_code: "01",
      day_weather_short: "多云",
      day_wind_direction: "微风",
      day_wind_direction_code: "0",
      day_wind_power: "3",
      day_wind_power_code: "0",
      max_degree: "16",
      min_degree: "10",
      night_weather: "多云",
      night_weather_code: "01",
      night_weather_short: "多云",
      night_wind_direction: "微风",
      night_wind_direction_code: "0",
      night_wind_power: "3",
      night_wind_power_code: "0",
      time: "2018-02-27"
    },
    3: {
      day_weather: "多云",
      day_weather_code: "01",
      day_weather_short: "多云",
      day_wind_direction: "微风",
      day_wind_direction_code: "0",
      day_wind_power: "3",
      day_wind_power_code: "0",
      max_degree: "19",
      min_degree: "12",
      night_weather: "小雨",
      night_weather_code: "07",
      night_weather_short: "小雨",
      night_wind_direction: "微风",
      night_wind_direction_code: "0",
      night_wind_power: "3",
      night_wind_power_code: "0",
      time: "2018-02-28"
    },
    4: {
      day_weather: "多云",
      day_weather_code: "01",
      day_weather_short: "多云",
      day_wind_direction: "微风",
      day_wind_direction_code: "0",
      day_wind_power: "3",
      day_wind_power_code: "0",
      max_degree: "22",
      min_degree: "11",
      night_weather: "多云",
      night_weather_code: "01",
      night_weather_short: "多云",
      night_wind_direction: "微风",
      night_wind_direction_code: "0",
      night_wind_power: "3",
      night_wind_power_code: "0",
      time: "2018-03-01"
    },
    5: {
      day_weather: "多云",
      day_weather_code: "01",
      day_weather_short: "多云",
      day_wind_direction: "微风",
      day_wind_direction_code: "0",
      day_wind_power: "3",
      day_wind_power_code: "0",
      max_degree: "23",
      min_degree: "14",
      night_weather: "小雨",
      night_weather_code: "07",
      night_weather_short: "小雨",
      night_wind_direction: "微风",
      night_wind_direction_code: "0",
      night_wind_power: "3",
      night_wind_power_code: "0",
      time: "2018-03-02"
    },
    6: {
      day_weather: "小雨",
      day_weather_code: "07",
      day_weather_short: "小雨",
      day_wind_direction: "微风",
      day_wind_direction_code: "0",
      day_wind_power: "3",
      day_wind_power_code: "0",
      max_degree: "20",
      min_degree: "12",
      night_weather: "小雨",
      night_weather_code: "07",
      night_weather_short: "小雨",
      night_wind_direction: "微风",
      night_wind_direction_code: "0",
      night_wind_power: "3",
      night_wind_power_code: "0",
      time: "2018-03-03"
    },
    7: {
      day_weather: "阵雨",
      day_weather_code: "03",
      day_weather_short: "阵雨",
      day_wind_direction: "微风",
      day_wind_direction_code: "0",
      day_wind_power: "3",
      day_wind_power_code: "0",
      max_degree: "17",
      min_degree: "14",
      night_weather: "阴",
      night_weather_code: "02",
      night_weather_short: "阴",
      night_wind_direction: "微风",
      night_wind_direction_code: "0",
      night_wind_power: "3",
      night_wind_power_code: "0",
      time: "2018-03-04"
    }
  }
};

function init(data) {
  var formatData = [],
    chartLabelData = [
      "2018-02-25",
      "2018-02-25",
      "2018-02-25",
      "2018-02-25",
      "2018-02-25",
      "2018-02-25",
      "2018-02-25",
      "2018-02-25"
    ],
    chartMaxData = [18, 13, 16, 19, 22, 23, 20, 17],
    chartMinData = [10, 9, 10, 12, 11, 14, 12, 14];

  var myChart = echarts.init(document.getElementById("chart-days"));
  option = {
    backgroundColor: "rgba(0,0,0,0.0)",
    color: ["#FFB74D", "#64B5F6"],
    animation: false,
    // renderAsImage: true,
    tooltip: {
      show: false
    },
    xAxis: [
      {
        type: "category",
        show: false,
        data: chartLabelData
      }
    ],
    yAxis: [
      {
        type: "value",
        show: false,
        boundaryGap: [1, 1],
        scale: true
      }
    ],
    grid: {
      x: 0,
      y: 0,
      y2: 0,
      height: 143,
      width: 740,
      borderWidth: "0px"
    },
    series: [
      {
        type: "line",
        data: chartMaxData,
        smooth: true,
        symbol: "circle",
        symbolSize: 8,
        clipOverflow: false,
        lineStyle: {
          normal: {
            width: 3
          }
        },
        label: {
          normal: {
            show: true,
            textStyle: {
              fontSize: "18",
              fontFamily: "微软雅黑",
              color: "#555555"
            },
            distance: 10,
            formatter: function (val) {
              if (val.dataIndex == 0) {
                return "{first|" + val.data + "°}";
              }
              return val.data + "°";
            },
            rich: {
              first: {
                fontSize: "18",
                fontFamily: "微软雅黑",
                color: "#C2C2C2"
              }
            }
          }
        }
      },
      {
        type: "line",
        data: chartMinData,
        smooth: true,
        symbol: "circle",
        symbolSize: 8,
        lineStyle: {
          normal: {
            width: 3
          }
        },
        label: {
          normal: {
            show: true,
            position: "bottom",
            textStyle: {
              fontSize: "18",
              fontFamily: "微软雅黑",
              color: "#555555"
            },
            distance: 10,
            formatter: function (val) {
              if (val.dataIndex == 0) {
                return "{first|" + val.data + "°}";
              }
              return val.data + "°";
            },
            rich: {
              first: {
                fontSize: "18",
                fontFamily: "微软雅黑",
                color: "#C2C2C2"
              }
            }
          }
        }
      }
    ]
  };

  myChart.setOption(option);
}

init(data);
