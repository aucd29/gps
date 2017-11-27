package net.sarangnamu.common.gps.domains

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

/**
 * Created by <a href="mailto:aucd29@hanwha.com">Burke Choi</a> on 2017. 11. 22.. <p/>
 */

data class Address (
    val results: List<AddressResult>,
    val status: String
)

data class AddressResult(
    val address_components: List<AddressComponent>,
    val formatted_address: String,
    val geometry: Geometry,
    val place_id: String,
    val types: List<String>
)

data class AddressComponent(
    val long_name: String,
    val short_name: String,
    val types: List<String>
) : Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
data class Geometry(
    val bounds: NorthEastSouthWest?,
    val location: Location,
    val location_type: String,
    val viewport: NorthEastSouthWest
)

data class Location(
    val lat: Double,
    val lng: Double
)

data class NorthEastSouthWest(
    val northeast: Location,
    val southwest: Location
)

// json format
/*
{
   "results" : [
      {
         "address_components" : [
            {
               "long_name" : "산22-1",
               "short_name" : "산22-1",
               "types" : [ "political", "premise" ]
            },
            {
               "long_name" : "삼송리",
               "short_name" : "삼송리",
               "types" : [ "political", "sublocality", "sublocality_level_3" ]
            },
            {
               "long_name" : "청천면",
               "short_name" : "청천면",
               "types" : [ "political", "sublocality", "sublocality_level_2" ]
            },
            {
               "long_name" : "괴산군",
               "short_name" : "괴산군",
               "types" : [ "locality", "political" ]
            },
            {
               "long_name" : "충청북도",
               "short_name" : "충청북도",
               "types" : [ "administrative_area_level_1", "political" ]
            },
            {
               "long_name" : "대한민국",
               "short_name" : "KR",
               "types" : [ "country", "political" ]
            },
            {
               "long_name" : "367-840",
               "short_name" : "367-840",
               "types" : [ "postal_code" ]
            }
         ],
         "formatted_address" : "대한민국 충청북도 괴산군 청천면 삼송리 산22-1",
         "geometry" : {
            "location" : {
               "lat" : 36.6636951,
               "lng" : 127.9153639
            },
            "location_type" : "ROOFTOP",
            "viewport" : {
               "northeast" : {
                  "lat" : 36.6650440802915,
                  "lng" : 127.9167128802915
               },
               "southwest" : {
                  "lat" : 36.6623461197085,
                  "lng" : 127.9140149197085
               }
            }
         },
         "place_id" : "ChIJNzr4eGf3ZDURWVW0BgGXDPg",
         "types" : [ "political", "premise" ]
      },
      {
         "address_components" : [
            {
               "long_name" : "삼송리",
               "short_name" : "삼송리",
               "types" : [ "political", "sublocality", "sublocality_level_3" ]
            },
            {
               "long_name" : "청천면",
               "short_name" : "청천면",
               "types" : [ "political", "sublocality", "sublocality_level_2" ]
            },
            {
               "long_name" : "괴산군",
               "short_name" : "괴산군",
               "types" : [ "locality", "political" ]
            },
            {
               "long_name" : "충청북도",
               "short_name" : "충청북도",
               "types" : [ "administrative_area_level_1", "political" ]
            },
            {
               "long_name" : "대한민국",
               "short_name" : "KR",
               "types" : [ "country", "political" ]
            },
            {
               "long_name" : "367-840",
               "short_name" : "367-840",
               "types" : [ "postal_code" ]
            }
         ],
         "formatted_address" : "대한민국 충청북도 괴산군 청천면 삼송리",
         "geometry" : {
            "bounds" : {
               "northeast" : {
                  "lat" : 36.6832816,
                  "lng" : 127.9411579
               },
               "southwest" : {
                  "lat" : 36.60863519999999,
                  "lng" : 127.8665198
               }
            },
            "location" : {
               "lat" : 36.6541538,
               "lng" : 127.9067497
            },
            "location_type" : "APPROXIMATE",
            "viewport" : {
               "northeast" : {
                  "lat" : 36.6832816,
                  "lng" : 127.9411579
               },
               "southwest" : {
                  "lat" : 36.60863519999999,
                  "lng" : 127.8665198
               }
            }
         },
         "place_id" : "ChIJk0UKz_D5ZDUR_5QUu4ZZCz8",
         "types" : [ "political", "sublocality", "sublocality_level_3" ]
      },
      {
         "address_components" : [
            {
               "long_name" : "청천면",
               "short_name" : "청천면",
               "types" : [ "political", "sublocality", "sublocality_level_2" ]
            },
            {
               "long_name" : "괴산군",
               "short_name" : "괴산군",
               "types" : [ "locality", "political" ]
            },
            {
               "long_name" : "충청북도",
               "short_name" : "충청북도",
               "types" : [ "administrative_area_level_1", "political" ]
            },
            {
               "long_name" : "대한민국",
               "short_name" : "KR",
               "types" : [ "country", "political" ]
            },
            {
               "long_name" : "367-840",
               "short_name" : "367-840",
               "types" : [ "postal_code" ]
            }
         ],
         "formatted_address" : "대한민국 충청북도 괴산군 청천면",
         "geometry" : {
            "bounds" : {
               "northeast" : {
                  "lat" : 36.7557106,
                  "lng" : 127.9411579
               },
               "southwest" : {
                  "lat" : 36.6072591,
                  "lng" : 127.7108619
               }
            },
            "location" : {
               "lat" : 36.6604297,
               "lng" : 127.7373157
            },
            "location_type" : "APPROXIMATE",
            "viewport" : {
               "northeast" : {
                  "lat" : 36.7557106,
                  "lng" : 127.9411579
               },
               "southwest" : {
                  "lat" : 36.6072591,
                  "lng" : 127.7108619
               }
            }
         },
         "place_id" : "ChIJJXpfJLv6ZDUR1kPEuFrPOas",
         "types" : [ "political", "sublocality", "sublocality_level_2" ]
      },
      {
         "address_components" : [
            {
               "long_name" : "괴산군",
               "short_name" : "괴산군",
               "types" : [ "locality", "political" ]
            },
            {
               "long_name" : "충청북도",
               "short_name" : "충청북도",
               "types" : [ "administrative_area_level_1", "political" ]
            },
            {
               "long_name" : "대한민국",
               "short_name" : "KR",
               "types" : [ "country", "political" ]
            }
         ],
         "formatted_address" : "대한민국 충청북도 괴산군",
         "geometry" : {
            "bounds" : {
               "northeast" : {
                  "lat" : 36.9467874,
                  "lng" : 128.0665889
               },
               "southwest" : {
                  "lat" : 36.6072591,
                  "lng" : 127.6205668
               }
            },
            "location" : {
               "lat" : 36.815669,
               "lng" : 127.7865791
            },
            "location_type" : "APPROXIMATE",
            "viewport" : {
               "northeast" : {
                  "lat" : 36.9467874,
                  "lng" : 128.0665889
               },
               "southwest" : {
                  "lat" : 36.6072591,
                  "lng" : 127.6205668
               }
            }
         },
         "place_id" : "ChIJfTIx8JrtZDUR8l4zh7ba7wA",
         "types" : [ "locality", "political" ]
      },
      {
         "address_components" : [
            {
               "long_name" : "367-847",
               "short_name" : "367-847",
               "types" : [ "postal_code" ]
            },
            {
               "long_name" : "청천면",
               "short_name" : "청천면",
               "types" : [ "political", "sublocality", "sublocality_level_2" ]
            },
            {
               "long_name" : "괴산군",
               "short_name" : "괴산군",
               "types" : [ "locality", "political" ]
            },
            {
               "long_name" : "충청북도",
               "short_name" : "충청북도",
               "types" : [ "administrative_area_level_1", "political" ]
            },
            {
               "long_name" : "대한민국",
               "short_name" : "KR",
               "types" : [ "country", "political" ]
            }
         ],
         "formatted_address" : "대한민국 충청북도 괴산군 청천면",
         "geometry" : {
            "bounds" : {
               "northeast" : {
                  "lat" : 36.6962518,
                  "lng" : 127.9411579
               },
               "southwest" : {
                  "lat" : 36.60863519999999,
                  "lng" : 127.8306269
               }
            },
            "location" : {
               "lat" : 36.6517281,
               "lng" : 127.9042711
            },
            "location_type" : "APPROXIMATE",
            "viewport" : {
               "northeast" : {
                  "lat" : 36.6962518,
                  "lng" : 127.9411579
               },
               "southwest" : {
                  "lat" : 36.60863519999999,
                  "lng" : 127.8306269
               }
            }
         },
         "place_id" : "ChIJk0UKz_D5ZDURRzA8Xua633A",
         "types" : [ "postal_code" ]
      },
      {
         "address_components" : [
            {
               "long_name" : "367-840",
               "short_name" : "367-840",
               "types" : [ "postal_code" ]
            },
            {
               "long_name" : "청천면",
               "short_name" : "청천면",
               "types" : [ "political", "sublocality", "sublocality_level_2" ]
            },
            {
               "long_name" : "괴산군",
               "short_name" : "괴산군",
               "types" : [ "locality", "political" ]
            },
            {
               "long_name" : "충청북도",
               "short_name" : "충청북도",
               "types" : [ "administrative_area_level_1", "political" ]
            },
            {
               "long_name" : "대한민국",
               "short_name" : "KR",
               "types" : [ "country", "political" ]
            }
         ],
         "formatted_address" : "대한민국 충청북도 괴산군 청천면",
         "geometry" : {
            "bounds" : {
               "northeast" : {
                  "lat" : 36.7557106,
                  "lng" : 127.9411579
               },
               "southwest" : {
                  "lat" : 36.6072591,
                  "lng" : 127.7108619
               }
            },
            "location" : {
               "lat" : 36.6701177,
               "lng" : 127.8300034
            },
            "location_type" : "APPROXIMATE",
            "viewport" : {
               "northeast" : {
                  "lat" : 36.7557106,
                  "lng" : 127.9411579
               },
               "southwest" : {
                  "lat" : 36.6072591,
                  "lng" : 127.7108619
               }
            }
         },
         "place_id" : "ChIJJXpfJLv6ZDUR74YhQRoS6j4",
         "types" : [ "postal_code" ]
      },
      {
         "address_components" : [
            {
               "long_name" : "충청북도",
               "short_name" : "충청북도",
               "types" : [ "administrative_area_level_1", "political" ]
            },
            {
               "long_name" : "대한민국",
               "short_name" : "KR",
               "types" : [ "country", "political" ]
            }
         ],
         "formatted_address" : "대한민국 충청북도",
         "geometry" : {
            "bounds" : {
               "northeast" : {
                  "lat" : 37.2626702,
                  "lng" : 128.6577072
               },
               "southwest" : {
                  "lat" : 36.0121372,
                  "lng" : 127.27609
               }
            },
            "location" : {
               "lat" : 36.8,
               "lng" : 127.7
            },
            "location_type" : "APPROXIMATE",
            "viewport" : {
               "northeast" : {
                  "lat" : 37.2626702,
                  "lng" : 128.6577072
               },
               "southwest" : {
                  "lat" : 36.0121372,
                  "lng" : 127.27609
               }
            }
         },
         "place_id" : "ChIJGf1r95uFYzUR6Q9wuJdKnLo",
         "types" : [ "administrative_area_level_1", "political" ]
      },
      {
         "address_components" : [
            {
               "long_name" : "대한민국",
               "short_name" : "KR",
               "types" : [ "country", "political" ]
            }
         ],
         "formatted_address" : "대한민국",
         "geometry" : {
            "bounds" : {
               "northeast" : {
                  "lat" : 38.63400000000001,
                  "lng" : 131.1603
               },
               "southwest" : {
                  "lat" : 33.0041,
                  "lng" : 124.5863
               }
            },
            "location" : {
               "lat" : 35.907757,
               "lng" : 127.766922
            },
            "location_type" : "APPROXIMATE",
            "viewport" : {
               "northeast" : {
                  "lat" : 38.63400000000001,
                  "lng" : 131.1603
               },
               "southwest" : {
                  "lat" : 33.0041,
                  "lng" : 124.5863
               }
            }
         },
         "place_id" : "ChIJm7oRy-tVZDURS9uIugCbJJE",
         "types" : [ "country", "political" ]
      }
   ],
   "status" : "OK"
}
 */