using Newtonsoft.Json;
using System.Net;

namespace CRUDAPIDemo
{
    public class ExceptionhandleNew
    {
        private readonly RequestDelegate _next;

        public ExceptionhandleNew(RequestDelegate next)

        {
            _next = next;
        }

        public async Task Invoke(HttpContext httpContext, Exception ex)
        {
            try
            {
                await _next(httpContext);
            }
            catch
            {
                await HandleExceptioinAsync(httpContext, ex);
            }
        }

        private Task HandleExceptioinAsync(HttpContext context, Exception ex)
        {
            context.Response.StatusCode = (int)HttpStatusCode.InternalServerError; // 500
            context.Response.ContentType = "application/json";

            return context.Response.WriteAsync(JsonConvert.SerializeObject(new
            {
                //StatusCode = context.Response.StatusCode,
                Message = "Exception Come",
                Status = "Error" // You might want to log this instead of sending it to the client
            }));
        }
    }
}
