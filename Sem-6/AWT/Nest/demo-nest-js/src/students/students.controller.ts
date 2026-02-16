import { Controller, Get } from '@nestjs/common';

@Controller('students')
export class StudentsController {
    @Get('engineering')
    findAll(){
        return 'This action returns all students';
    }
}
