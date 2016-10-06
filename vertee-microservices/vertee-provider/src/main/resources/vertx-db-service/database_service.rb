require 'vertx/vertx'
require 'vertx/util/utils.rb'
# Generated from com.jedlab.vertee.DatabaseService
module VertxDbService
  class DatabaseService
    # @private
    # @param j_del [::VertxDbService::DatabaseService] the java delegate
    def initialize(j_del)
      @j_del = j_del
    end
    # @private
    # @return [::VertxDbService::DatabaseService] the underlying java delegate
    def j_del
      @j_del
    end
    # @param [::Vertx::Vertx] vertx 
    # @return [::VertxDbService::DatabaseService]
    def self.create(vertx=nil)
      if vertx.class.method_defined?(:j_del) && !block_given?
        return ::Vertx::Util::Utils.safe_create(Java::ComJedlabVertee::DatabaseService.java_method(:create, [Java::IoVertxCore::Vertx.java_class]).call(vertx.j_del),::VertxDbService::DatabaseService)
      end
      raise ArgumentError, "Invalid arguments when calling create(vertx)"
    end
    # @param [::Vertx::Vertx] vertx 
    # @param [String] address 
    # @return [::VertxDbService::DatabaseService]
    def self.create_proxy(vertx=nil,address=nil)
      if vertx.class.method_defined?(:j_del) && address.class == String && !block_given?
        return ::Vertx::Util::Utils.safe_create(Java::ComJedlabVertee::DatabaseService.java_method(:createProxy, [Java::IoVertxCore::Vertx.java_class,Java::java.lang.String.java_class]).call(vertx.j_del,address),::VertxDbService::DatabaseService)
      end
      raise ArgumentError, "Invalid arguments when calling create_proxy(vertx,address)"
    end
    # @param [Hash{String => Object}] document 
    # @yield 
    # @return [void]
    def persist(document=nil)
      if document.class == Hash && block_given?
        return @j_del.java_method(:persist, [Java::IoVertxCoreJson::JsonObject.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_json_object(document),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
      end
      raise ArgumentError, "Invalid arguments when calling persist(document)"
    end
  end
end
