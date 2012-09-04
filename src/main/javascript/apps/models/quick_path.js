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
      findAll: "/quick_paths.json",
      findOne : "/quick_paths/{id}.json",
      create : "/quick_paths.json",
      update : "/quick_paths/{id}.json",
      destroy : "/quick_paths/{id}.json"
    },
    /* @Prototype */
    { });
});