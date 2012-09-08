steal('jquery/model', function() {
  /**
   * @class Apps.Models.QuickPath
   * @parent index
   * @inherits jQuery.Model
   * Wraps backend quick_path services.  
   */
  $.Model('Apps.Models.QuickPath',
    /* @Static */
    {
      findAll: "/sample/service/quick_paths.json",
      findOne : "/sample/service/quick_paths/{id}.json",
      create : "/sample/service/quick_paths.json",
      update : "/sample/service/quick_paths/{id}.json",
      destroy : "/sample/service/quick_paths/{id}.json"
    },
    /* @Prototype */
    { });
});