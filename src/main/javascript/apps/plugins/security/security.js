steal(function() {
  Array.prototype.filter || (Array.prototype.filter = function(func) {
    var i = 0, ret = [];
    for (; i < this.length; i++)
      if (func(this[i])) ret.unshift(this[i]);
    return ret;
  });

  Array.prototype.forEach || (Array.prototype.forEach = function(func) {
    for (var i = 0; i < this.length; i++)
      func(this[i]);
  });

  var findProfile = function() {
    var profile;
    if (window.Sample && Sample.Plugin && Sample.Plugin.userProfile) {
      profile = Sample.Plugin.userProfile;
    } else {
      profile = User.getUserProfile();
    }
    return profile;
  };
  
  var assumeFunction = function(aFunction) {
    return !aFunction ? function() {
    } : aFunction;
  };
  
  var findMatches = function(permissionsToFilter) {
    var matchedPermissions = [];
    var profile = findProfile();
    // Array.prototype.forEach isn't supported by IE8-
    permissionsToFilter.forEach(function(perm) {
      var perm_tokens = perm.split(":");
      if (profile && profile.permissions) {
        profile.permissions.filter(function(uperm) {
          var uperm_tokens = uperm.split(":");
          for ( var i = 0; i < uperm_tokens.length; i++) {
            if (uperm_tokens[i].split(",").filter(function(part) {
              return part == '*' || part == perm_tokens[i];
            }).length == 0) {
              return false;
            }
            ;
          }
          return true;
        }).forEach(function(uperm) {
          matchedPermissions.push(uperm);
        });
      }
    });
    return matchedPermissions;
  };
  var arrayify = function(arrayCandidate) {
    if (Object.prototype.toString.call(arrayCandidate) !== Object.prototype.toString.call([])) {
      arrayCandidate = [ arrayCandidate ];
    }
    return arrayCandidate;
  };
  /**
   * function filterByPermission
   * 
   * @param permissionsToFilter String or Array of allowed roles for executing toExecMatched
   * @param toExecMatched Function (String) to execute on role match
   * @param toExecNoMatch Function (String) to execute when no role matched
   * @returns void
   */
  window.secureByPermission = function(permissionsToFilter, toExecMatched, toExecNoMatch) {
    permissionsToFilter = arrayify(permissionsToFilter);
    var defMatch = assumeFunction(toExecMatched);
    var defNoMatch = assumeFunction(toExecNoMatch);
    var matchedPermissions = findMatches(permissionsToFilter);

    if (matchedPermissions.length > 0) {
      defMatch(matchedPermissions);
    } else {
      defNoMatch();
    }
  };

  /**
   * function filterByRole
   * 
   * @param rolenames String or Array of allowed roles for executing toExecMatched
   * @param toExecMatched Function (String) to execute on role match
   * @param toExecNoMatch Function (String) to execute when no role matched
   * @returns void
   */
  window.secureByRole = function(rolenames, toExecMatched, toExecNoMatch) {
    var profile = findProfile();

    var rolearr = Object.prototype.toString.call(rolenames) == Object.prototype.toString.call([]) ? rolenames : [ rolenames ];
    var defMatch = assumeFunction(toExecMatched);
    var defNoMatch = assumeFunction(toExecNoMatch);
    var currentRole = !profile ? null : profile.role;

    var iter_func, iter_obj;
    if (typeof (Array.prototype.indexOf) == 'function') {
      iter_func = Array.prototype.indexOf;
      iter_obj = rolearr;
    }

    try {
      if (!!currentRole && (iter_func ? iter_func.call(rolearr, currentRole) > -1 : $.inArray(currentRole, rolearr) > -1)) {
        defMatch(currentRole);
      } else {
        defNoMatch(currentRole);
      }
    } catch (e) {
      steal.dev.log("filterByRole EXCEPTION CAUGHT", { eData : e });
    }
  };
});
