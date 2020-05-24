import { Position } from './position';

export class DepartmentDomain{
    id : string;
	positionObj : Position;
	name : string;
	competencies : string;
	responsibilities : string;
	entryCriteria : string;
	activate : boolean;
}